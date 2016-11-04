/**
 * 
 */
package TreeSetTest;

import java.util.Objects;

/**
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年10月31日
 */
public class Item implements Comparable<Item> {

    private int partNumber;
    private String description;
    public int getPartNumber() {
        return partNumber;
    }
    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }
    public String getDescription() {
        return description;
    }
    public Item(int partNumber, String description) {
        super();
        this.partNumber = partNumber;
        this.description = description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[partNumber =" + partNumber +", description = " + description +"]";
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass()!=obj.getClass())return false;
        Item other = (Item) obj;
        return this.partNumber == other.partNumber && this.description.equals(other.description);
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(partNumber, description);
    }
    @Override
    public int compareTo(Item o) {
        return Integer.compare(partNumber, o.partNumber);
    }

}
