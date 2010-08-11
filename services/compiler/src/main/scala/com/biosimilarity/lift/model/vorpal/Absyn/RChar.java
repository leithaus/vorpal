package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class RChar extends Reg {
  public final Character char_;

  public RChar(Character p1) { char_ = p1; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.Reg.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.RChar) {
      com.biosimilarity.lift.model.vorpal.Absyn.RChar x = (com.biosimilarity.lift.model.vorpal.Absyn.RChar)o;
      return this.char_.equals(x.char_);
    }
    return false;
  }

  public int hashCode() {
    return this.char_.hashCode();
  }


}