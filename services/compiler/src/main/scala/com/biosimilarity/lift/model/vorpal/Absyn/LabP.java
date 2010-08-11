package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class LabP extends Label {
  public final LabelId labelid_;
  public final ListProfItem listprofitem_;

  public LabP(LabelId p1, ListProfItem p2) { labelid_ = p1; listprofitem_ = p2; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Label.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabP) {
      com.biosimilarity.lift.model.vorpal.Absyn.LabP x = (com.biosimilarity.lift.model.vorpal.Absyn.LabP)o;
      return this.labelid_.equals(x.labelid_) && this.listprofitem_.equals(x.listprofitem_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.labelid_.hashCode())+this.listprofitem_.hashCode();
  }


}