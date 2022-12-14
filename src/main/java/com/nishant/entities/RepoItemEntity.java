/**
 *
 */
package com.nishant.entities;

import com.nishant.interfaces.RepoItemsInterface;

import javax.persistence.*;

/**
 * @author nishant.b.grover
 *
 */
@Entity
@Table(name = "REPO_ITEMS")
public class RepoItemEntity implements RepoItemsInterface {
    @Id
    @Column(name = "R_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rId;

    @Column(name = "R_ITEM_NAME", nullable = false)
    private String rName;

    @Column(name = "R_REFIGERATE_DATE")
    private String rFridgeDate;

    @Column(name = "R_PANTRY_DATE", nullable = false)
    private String rPantryDate;

    @Column(name = "R_FREEZE_DATE", nullable = false)
    private String rFreezeDate;

    @Override
    public String getrFreezeDate() {
        return this.rFreezeDate;
    }

    @Override
    public void setrFreezeDate(String rFreezeDate) {
        this.rFreezeDate = rFreezeDate;

    }

    @Override
    public String getrFridgeDate() {
        return this.rFridgeDate;
    }

    @Override
    public void setrFridgeDate(String rFridgeDate) {
        this.rFridgeDate = rFridgeDate;
    }

    @Override
    public Integer getrId() {
        return this.rId;
    }

    @Override
    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Override
    public String getrName() {
        return this.rName;
    }

    @Override
    public void setrName(String rName) {
        this.rName = rName;
    }

    @Override
    public String getrPantryDate() {
        return this.rPantryDate;
    }

    @Override
    public void setrPantryDate(String rPantryDate) {
        this.rPantryDate = rPantryDate;
    }

    @Override
    public String toString() {
        return "RepoItemEntity [rId=" + this.rId + ", rName=" + this.rName + ", rFridgeDate=" + this.rFridgeDate
                + ", rPantryDate=" + this.rPantryDate + ", rFreezeDate=" + this.rFreezeDate + "]";
    }
}
