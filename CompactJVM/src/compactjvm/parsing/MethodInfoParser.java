package compactjvm.parsing;

import compactjvm.classfile.ClassFile;
import compactjvm.cpentities.CPUtf8;
import compactjvm.attributes.Attribute;
import compactjvm.classfile.MTHEntity;
import compactjvm.exceptions.ParsingException;
import java.io.DataInputStream;
import java.io.IOException;
import compactjvm.jvm.JVMLogger;

/**
 * Parser for methodinfo
 *
 * @author Adam Vesecky
 */
public class MethodInfoParser {

    public MTHEntity parseMethodEntity(ClassFile cls, DataInputStream dis) throws IOException, ParsingException {

        MTHEntity ent = new MTHEntity();
        ent.accessFlags = dis.readShort();
        ent.nameIndex = dis.readShort();
        ent.descriptorIndex = dis.readShort();
        ent.attributesCount = dis.readShort();

        // nameindex and descriptorindex must point into constant pool UTF8 entity
        String name = ((CPUtf8)cls.cpEntities[ent.nameIndex]).value;
        String descriptor = ((CPUtf8)cls.cpEntities[ent.descriptorIndex]).value;
        
        ent.name = name;
        ent.descriptor = descriptor;
        
        JVMLogger.log(JVMLogger.TAG_PARSING, "Parsed method entity; access flags: "+ent.accessFlags + 
                " ;name: "+name+" ;descriptor:"+descriptor+
                " ;attributesCount: "+ent.attributesCount,4);
        
        if (ent.attributesCount != 0) {
            JVMLogger.log(JVMLogger.TAG_PARSING, "Parsing attributes",4);
            
            ent.attrs = new Attribute[ent.attributesCount];

            AttributeParser parser = new AttributeParser();
            
            for (int i = 0; i < ent.attributesCount; i++) {
                Attribute attr = parser.parseAttributeEntity(cls,dis);
                ent.attrs[i] = attr;
            }
        }
        return ent;
    }
}
