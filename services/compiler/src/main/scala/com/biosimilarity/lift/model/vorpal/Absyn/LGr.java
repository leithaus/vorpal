package com.biosimilarity.lift.model.vorpal.Absyn; // Java Package generated by the BNF Converter.

public class LGr extends LGrammar {
  public final ListLDef listldef_;

  public LGr(ListLDef p1) { listldef_ = p1; }

  public <R,A> R accept(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof com.biosimilarity.lift.model.vorpal.Absyn.LGr) {
      com.biosimilarity.lift.model.vorpal.Absyn.LGr x = (com.biosimilarity.lift.model.vorpal.Absyn.LGr)o;
      return this.listldef_.equals(x.listldef_);
    }
    return false;
  }

  public int hashCode() {
    return this.listldef_.hashCode();
  }


}