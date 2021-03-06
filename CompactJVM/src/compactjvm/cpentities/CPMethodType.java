package compactjvm.cpentities;

import compactjvm.definitions.ConstantPoolType;

/**
 * Constant pool method type entity
 * @author Adam Vesecky
 */
public class CPMethodType extends CPEntity {
 
    public int descriptorIndex;
    
    public CPMethodType(){
        super(ConstantPoolType.CPT_MethodType);
    }

    @Override
    public int getSize() {
        return 1;
    }
}
