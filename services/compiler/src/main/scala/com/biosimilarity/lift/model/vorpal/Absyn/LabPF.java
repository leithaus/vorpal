package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class LabPF extends Label {
  public final LabelId labelid_1, labelid_2;
  public final ListProfItem listprofitem_;

  public LabPF(LabelId p1, LabelId p2, ListProfItem p3) { labelid_1 = p1; labelid_2 = p2; listprofitem_ = p3; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Label.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabPF) {
      com.biosimilarity.lift.model.vorpal.Absyn.LabPF x = (com.biosimilarity.lift.model.vorpal.Absyn.LabPF)o;
      return this.labelid_1.equals(x.labelid_1) && this.labelid_2.equals(x.labelid_2) && this.listprofitem_.equals(x.listprofitem_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(37*(this.labelid_1.hashCode())+this.labelid_2.hashCode())+this.listprofitem_.hashCode();
  }


}
