package com.biosimilarity.lift.model.vorpal;
import com.biosimilarity.lift.model.vorpal.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + 2;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       _n_ = _n_ - 2;
       backup();
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.LDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.LDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListLDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListLDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Grammar foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Grammar foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListDef foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListDef foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListItem foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListItem foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Def foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Def foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Item foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Item foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Cat foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Cat foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Label foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Label foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.LabelId foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.LabelId foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ProfItem foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ProfItem foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.IntList foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.IntList foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListInteger foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListInteger foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListIntList foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListIntList foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListProfItem foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListProfItem foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Arg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Arg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListArg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListArg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListString foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListString foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListRHS foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListRHS foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.RHS foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.RHS foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.Reg foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.Reg foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(com.biosimilarity.lift.model.vorpal.Absyn.ListIdent foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(com.biosimilarity.lift.model.vorpal.Absyn.ListIdent foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LGr)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LGr _lgr = (com.biosimilarity.lift.model.vorpal.Absyn.LGr) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_lgr.listldef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.LDef foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.DefAll)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.DefAll _defall = (com.biosimilarity.lift.model.vorpal.Absyn.DefAll) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_defall.def_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.DefSome)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.DefSome _defsome = (com.biosimilarity.lift.model.vorpal.Absyn.DefSome) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_defsome.listident_, 0);
       render(":");
       pp(_defsome.def_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LDefView)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LDefView _ldefview = (com.biosimilarity.lift.model.vorpal.Absyn.LDefView) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("views");
       pp(_ldefview.listident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListLDef foo, int _i_)
  {
     for (java.util.Iterator<LDef> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Grammar foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Grammar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Grammar _grammar = (com.biosimilarity.lift.model.vorpal.Absyn.Grammar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_grammar.listdef_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListDef foo, int _i_)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListItem foo, int _i_)
  {
     for (java.util.Iterator<Item> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Def foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Rule)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Rule _rule = (com.biosimilarity.lift.model.vorpal.Absyn.Rule) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rule.label_, 0);
       render(".");
       pp(_rule.cat_, 0);
       render("::=");
       pp(_rule.listitem_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Comment)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Comment _comment = (com.biosimilarity.lift.model.vorpal.Absyn.Comment) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("comment");
       printQuoted(_comment.string_);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Comments)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Comments _comments = (com.biosimilarity.lift.model.vorpal.Absyn.Comments) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("comment");
       printQuoted(_comments.string_1);
       printQuoted(_comments.string_2);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Internal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Internal _internal = (com.biosimilarity.lift.model.vorpal.Absyn.Internal) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("internal");
       pp(_internal.label_, 0);
       render(".");
       pp(_internal.cat_, 0);
       render("::=");
       pp(_internal.listitem_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Token)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Token _token = (com.biosimilarity.lift.model.vorpal.Absyn.Token) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("token");
       pp(_token.ident_, 0);
       pp(_token.reg_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.PosToken)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.PosToken _postoken = (com.biosimilarity.lift.model.vorpal.Absyn.PosToken) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("position");
       render("token");
       pp(_postoken.ident_, 0);
       pp(_postoken.reg_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Entryp)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Entryp _entryp = (com.biosimilarity.lift.model.vorpal.Absyn.Entryp) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("entrypoints");
       pp(_entryp.listident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Separator)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Separator _separator = (com.biosimilarity.lift.model.vorpal.Absyn.Separator) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("separator");
       pp(_separator.minimumsize_, 0);
       pp(_separator.cat_, 0);
       printQuoted(_separator.string_);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Terminator)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Terminator _terminator = (com.biosimilarity.lift.model.vorpal.Absyn.Terminator) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("terminator");
       pp(_terminator.minimumsize_, 0);
       pp(_terminator.cat_, 0);
       printQuoted(_terminator.string_);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Coercions)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Coercions _coercions = (com.biosimilarity.lift.model.vorpal.Absyn.Coercions) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("coercions");
       pp(_coercions.ident_, 0);
       pp(_coercions.integer_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Rules)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Rules _rules = (com.biosimilarity.lift.model.vorpal.Absyn.Rules) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("rules");
       pp(_rules.ident_, 0);
       render("::=");
       pp(_rules.listrhs_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Function)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Function _function = (com.biosimilarity.lift.model.vorpal.Absyn.Function) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("define");
       pp(_function.ident_, 0);
       pp(_function.listarg_, 0);
       render("=");
       pp(_function.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Layout)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Layout _layout = (com.biosimilarity.lift.model.vorpal.Absyn.Layout) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("layout");
       pp(_layout.liststring_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop _layoutstop = (com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("layout");
       render("stop");
       pp(_layoutstop.liststring_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop _layouttop = (com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("layout");
       render("toplevel");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Item foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Terminal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Terminal _terminal = (com.biosimilarity.lift.model.vorpal.Absyn.Terminal) foo;
       if (_i_ > 0) render(_L_PAREN);
       printQuoted(_terminal.string_);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.NTerminal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.NTerminal _nterminal = (com.biosimilarity.lift.model.vorpal.Absyn.NTerminal) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_nterminal.cat_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Cat foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListCat)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListCat _listcat = (com.biosimilarity.lift.model.vorpal.Absyn.ListCat) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[");
       pp(_listcat.cat_, 0);
       render("]");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.IdCat)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.IdCat _idcat = (com.biosimilarity.lift.model.vorpal.Absyn.IdCat) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_idcat.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Label foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabNoP)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabNoP _labnop = (com.biosimilarity.lift.model.vorpal.Absyn.LabNoP) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_labnop.labelid_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabP)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabP _labp = (com.biosimilarity.lift.model.vorpal.Absyn.LabP) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_labp.labelid_, 0);
       pp(_labp.listprofitem_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabPF)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabPF _labpf = (com.biosimilarity.lift.model.vorpal.Absyn.LabPF) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_labpf.labelid_1, 0);
       pp(_labpf.labelid_2, 0);
       pp(_labpf.listprofitem_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabF)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabF _labf = (com.biosimilarity.lift.model.vorpal.Absyn.LabF) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_labf.labelid_1, 0);
       pp(_labf.labelid_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.LabelId foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Id)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Id _id = (com.biosimilarity.lift.model.vorpal.Absyn.Id) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_id.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Wild)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Wild _wild = (com.biosimilarity.lift.model.vorpal.Absyn.Wild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListE)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListE _liste = (com.biosimilarity.lift.model.vorpal.Absyn.ListE) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[");
       render("]");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListCons)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListCons _listcons = (com.biosimilarity.lift.model.vorpal.Absyn.ListCons) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       render(":");
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListOne)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListOne _listone = (com.biosimilarity.lift.model.vorpal.Absyn.ListOne) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       render(":");
       render("[");
       render("]");
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ProfItem foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ProfIt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ProfIt _profit = (com.biosimilarity.lift.model.vorpal.Absyn.ProfIt) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("(");
       render("[");
       pp(_profit.listintlist_, 0);
       render("]");
       render(",");
       render("[");
       pp(_profit.listinteger_, 0);
       render("]");
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.IntList foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Ints)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Ints _ints = (com.biosimilarity.lift.model.vorpal.Absyn.Ints) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("[");
       pp(_ints.listinteger_, 0);
       render("]");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListInteger foo, int _i_)
  {
     for (java.util.Iterator<Integer> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListIntList foo, int _i_)
  {
     for (java.util.Iterator<IntList> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListProfItem foo, int _i_)
  {
     for (java.util.Iterator<ProfItem> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Arg foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Arg)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Arg _arg = (com.biosimilarity.lift.model.vorpal.Absyn.Arg) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_arg.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListArg foo, int _i_)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Cons)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Cons _cons = (com.biosimilarity.lift.model.vorpal.Absyn.Cons) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_cons.exp_1, 1);
       render(":");
       pp(_cons.exp_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.App)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.App _app = (com.biosimilarity.lift.model.vorpal.Absyn.App) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_app.ident_, 0);
       pp(_app.listexp_, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Var)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Var _var = (com.biosimilarity.lift.model.vorpal.Absyn.Var) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_var.ident_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitInt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitInt _litint = (com.biosimilarity.lift.model.vorpal.Absyn.LitInt) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_litint.integer_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitChar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitChar _litchar = (com.biosimilarity.lift.model.vorpal.Absyn.LitChar) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_litchar.char_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitString)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitString _litstring = (com.biosimilarity.lift.model.vorpal.Absyn.LitString) foo;
       if (_i_ > 2) render(_L_PAREN);
       printQuoted(_litstring.string_);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitDouble)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitDouble _litdouble = (com.biosimilarity.lift.model.vorpal.Absyn.LitDouble) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_litdouble.double_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.List)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.List _list = (com.biosimilarity.lift.model.vorpal.Absyn.List) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("[");
       pp(_list.listexp_, 0);
       render("]");
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListExp foo, int _i_)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render("");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListString foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListRHS foo, int _i_)
  {
     for (java.util.Iterator<RHS> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render("|");
       } else {
         render("");
       }
     }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.RHS foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RHS)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RHS _rhs = (com.biosimilarity.lift.model.vorpal.Absyn.RHS) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rhs.listitem_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.MNonempty)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.MNonempty _mnonempty = (com.biosimilarity.lift.model.vorpal.Absyn.MNonempty) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("nonempty");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.MEmpty)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.MEmpty _mempty = (com.biosimilarity.lift.model.vorpal.Absyn.MEmpty) foo;
       if (_i_ > 0) render(_L_PAREN);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.Reg foo, int _i_)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RSeq)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RSeq _rseq = (com.biosimilarity.lift.model.vorpal.Absyn.RSeq) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_rseq.reg_1, 2);
       pp(_rseq.reg_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAlt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAlt _ralt = (com.biosimilarity.lift.model.vorpal.Absyn.RAlt) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_ralt.reg_1, 1);
       render("|");
       pp(_ralt.reg_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RMinus)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RMinus _rminus = (com.biosimilarity.lift.model.vorpal.Absyn.RMinus) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_rminus.reg_1, 2);
       render("-");
       pp(_rminus.reg_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RStar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RStar _rstar = (com.biosimilarity.lift.model.vorpal.Absyn.RStar) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_rstar.reg_, 3);
       render("*");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RPlus)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RPlus _rplus = (com.biosimilarity.lift.model.vorpal.Absyn.RPlus) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_rplus.reg_, 3);
       render("+");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ROpt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ROpt _ropt = (com.biosimilarity.lift.model.vorpal.Absyn.ROpt) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_ropt.reg_, 3);
       render("?");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.REps)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.REps _reps = (com.biosimilarity.lift.model.vorpal.Absyn.REps) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("eps");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RChar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RChar _rchar = (com.biosimilarity.lift.model.vorpal.Absyn.RChar) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_rchar.char_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAlts)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAlts _ralts = (com.biosimilarity.lift.model.vorpal.Absyn.RAlts) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("[");
       printQuoted(_ralts.string_);
       render("]");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RSeqs)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RSeqs _rseqs = (com.biosimilarity.lift.model.vorpal.Absyn.RSeqs) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("{");
       printQuoted(_rseqs.string_);
       render("}");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RDigit)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RDigit _rdigit = (com.biosimilarity.lift.model.vorpal.Absyn.RDigit) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("digit");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RLetter)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RLetter _rletter = (com.biosimilarity.lift.model.vorpal.Absyn.RLetter) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("letter");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RUpper)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RUpper _rupper = (com.biosimilarity.lift.model.vorpal.Absyn.RUpper) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("upper");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RLower)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RLower _rlower = (com.biosimilarity.lift.model.vorpal.Absyn.RLower) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("lower");
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAny)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAny _rany = (com.biosimilarity.lift.model.vorpal.Absyn.RAny) foo;
       if (_i_ > 3) render(_L_PAREN);
       render("char");
       if (_i_ > 3) render(_R_PAREN);
    }
  }

  private static void pp(com.biosimilarity.lift.model.vorpal.Absyn.ListIdent foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), 0);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }
  }


  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.LGrammar foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LGr)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LGr _lgr = (com.biosimilarity.lift.model.vorpal.Absyn.LGr) foo;
       render("(");
       render("LGr");
       render("[");
       sh(_lgr.listldef_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.LDef foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.DefAll)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.DefAll _defall = (com.biosimilarity.lift.model.vorpal.Absyn.DefAll) foo;
       render("(");
       render("DefAll");
       sh(_defall.def_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.DefSome)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.DefSome _defsome = (com.biosimilarity.lift.model.vorpal.Absyn.DefSome) foo;
       render("(");
       render("DefSome");
       render("[");
       sh(_defsome.listident_);
       render("]");
       sh(_defsome.def_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LDefView)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LDefView _ldefview = (com.biosimilarity.lift.model.vorpal.Absyn.LDefView) foo;
       render("(");
       render("LDefView");
       render("[");
       sh(_ldefview.listident_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListLDef foo)
  {
     for (java.util.Iterator<LDef> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Grammar foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Grammar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Grammar _grammar = (com.biosimilarity.lift.model.vorpal.Absyn.Grammar) foo;
       render("(");
       render("Grammar");
       render("[");
       sh(_grammar.listdef_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListDef foo)
  {
     for (java.util.Iterator<Def> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListItem foo)
  {
     for (java.util.Iterator<Item> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Def foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Rule)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Rule _rule = (com.biosimilarity.lift.model.vorpal.Absyn.Rule) foo;
       render("(");
       render("Rule");
       sh(_rule.label_);
       sh(_rule.cat_);
       render("[");
       sh(_rule.listitem_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Comment)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Comment _comment = (com.biosimilarity.lift.model.vorpal.Absyn.Comment) foo;
       render("(");
       render("Comment");
       sh(_comment.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Comments)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Comments _comments = (com.biosimilarity.lift.model.vorpal.Absyn.Comments) foo;
       render("(");
       render("Comments");
       sh(_comments.string_1);
       sh(_comments.string_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Internal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Internal _internal = (com.biosimilarity.lift.model.vorpal.Absyn.Internal) foo;
       render("(");
       render("Internal");
       sh(_internal.label_);
       sh(_internal.cat_);
       render("[");
       sh(_internal.listitem_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Token)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Token _token = (com.biosimilarity.lift.model.vorpal.Absyn.Token) foo;
       render("(");
       render("Token");
       sh(_token.ident_);
       sh(_token.reg_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.PosToken)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.PosToken _postoken = (com.biosimilarity.lift.model.vorpal.Absyn.PosToken) foo;
       render("(");
       render("PosToken");
       sh(_postoken.ident_);
       sh(_postoken.reg_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Entryp)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Entryp _entryp = (com.biosimilarity.lift.model.vorpal.Absyn.Entryp) foo;
       render("(");
       render("Entryp");
       render("[");
       sh(_entryp.listident_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Separator)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Separator _separator = (com.biosimilarity.lift.model.vorpal.Absyn.Separator) foo;
       render("(");
       render("Separator");
       sh(_separator.minimumsize_);
       sh(_separator.cat_);
       sh(_separator.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Terminator)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Terminator _terminator = (com.biosimilarity.lift.model.vorpal.Absyn.Terminator) foo;
       render("(");
       render("Terminator");
       sh(_terminator.minimumsize_);
       sh(_terminator.cat_);
       sh(_terminator.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Coercions)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Coercions _coercions = (com.biosimilarity.lift.model.vorpal.Absyn.Coercions) foo;
       render("(");
       render("Coercions");
       sh(_coercions.ident_);
       sh(_coercions.integer_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Rules)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Rules _rules = (com.biosimilarity.lift.model.vorpal.Absyn.Rules) foo;
       render("(");
       render("Rules");
       sh(_rules.ident_);
       render("[");
       sh(_rules.listrhs_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Function)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Function _function = (com.biosimilarity.lift.model.vorpal.Absyn.Function) foo;
       render("(");
       render("Function");
       sh(_function.ident_);
       render("[");
       sh(_function.listarg_);
       render("]");
       sh(_function.exp_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Layout)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Layout _layout = (com.biosimilarity.lift.model.vorpal.Absyn.Layout) foo;
       render("(");
       render("Layout");
       render("[");
       sh(_layout.liststring_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop _layoutstop = (com.biosimilarity.lift.model.vorpal.Absyn.LayoutStop) foo;
       render("(");
       render("LayoutStop");
       render("[");
       sh(_layoutstop.liststring_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop _layouttop = (com.biosimilarity.lift.model.vorpal.Absyn.LayoutTop) foo;
       render("LayoutTop");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Item foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Terminal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Terminal _terminal = (com.biosimilarity.lift.model.vorpal.Absyn.Terminal) foo;
       render("(");
       render("Terminal");
       sh(_terminal.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.NTerminal)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.NTerminal _nterminal = (com.biosimilarity.lift.model.vorpal.Absyn.NTerminal) foo;
       render("(");
       render("NTerminal");
       sh(_nterminal.cat_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Cat foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListCat)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListCat _listcat = (com.biosimilarity.lift.model.vorpal.Absyn.ListCat) foo;
       render("(");
       render("ListCat");
       sh(_listcat.cat_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.IdCat)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.IdCat _idcat = (com.biosimilarity.lift.model.vorpal.Absyn.IdCat) foo;
       render("(");
       render("IdCat");
       sh(_idcat.ident_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Label foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabNoP)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabNoP _labnop = (com.biosimilarity.lift.model.vorpal.Absyn.LabNoP) foo;
       render("(");
       render("LabNoP");
       sh(_labnop.labelid_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabP)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabP _labp = (com.biosimilarity.lift.model.vorpal.Absyn.LabP) foo;
       render("(");
       render("LabP");
       sh(_labp.labelid_);
       render("[");
       sh(_labp.listprofitem_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabPF)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabPF _labpf = (com.biosimilarity.lift.model.vorpal.Absyn.LabPF) foo;
       render("(");
       render("LabPF");
       sh(_labpf.labelid_1);
       sh(_labpf.labelid_2);
       render("[");
       sh(_labpf.listprofitem_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LabF)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LabF _labf = (com.biosimilarity.lift.model.vorpal.Absyn.LabF) foo;
       render("(");
       render("LabF");
       sh(_labf.labelid_1);
       sh(_labf.labelid_2);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.LabelId foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Id)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Id _id = (com.biosimilarity.lift.model.vorpal.Absyn.Id) foo;
       render("(");
       render("Id");
       sh(_id.ident_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Wild)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Wild _wild = (com.biosimilarity.lift.model.vorpal.Absyn.Wild) foo;
       render("Wild");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListE)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListE _liste = (com.biosimilarity.lift.model.vorpal.Absyn.ListE) foo;
       render("ListE");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListCons)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListCons _listcons = (com.biosimilarity.lift.model.vorpal.Absyn.ListCons) foo;
       render("ListCons");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ListOne)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ListOne _listone = (com.biosimilarity.lift.model.vorpal.Absyn.ListOne) foo;
       render("ListOne");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ProfItem foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ProfIt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ProfIt _profit = (com.biosimilarity.lift.model.vorpal.Absyn.ProfIt) foo;
       render("(");
       render("ProfIt");
       render("[");
       sh(_profit.listintlist_);
       render("]");
       render("[");
       sh(_profit.listinteger_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.IntList foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Ints)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Ints _ints = (com.biosimilarity.lift.model.vorpal.Absyn.Ints) foo;
       render("(");
       render("Ints");
       render("[");
       sh(_ints.listinteger_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListInteger foo)
  {
     for (java.util.Iterator<Integer> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListIntList foo)
  {
     for (java.util.Iterator<IntList> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListProfItem foo)
  {
     for (java.util.Iterator<ProfItem> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Arg foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Arg)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Arg _arg = (com.biosimilarity.lift.model.vorpal.Absyn.Arg) foo;
       render("(");
       render("Arg");
       sh(_arg.ident_);
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListArg foo)
  {
     for (java.util.Iterator<Arg> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Exp foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Cons)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Cons _cons = (com.biosimilarity.lift.model.vorpal.Absyn.Cons) foo;
       render("(");
       render("Cons");
       sh(_cons.exp_1);
       sh(_cons.exp_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.App)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.App _app = (com.biosimilarity.lift.model.vorpal.Absyn.App) foo;
       render("(");
       render("App");
       sh(_app.ident_);
       render("[");
       sh(_app.listexp_);
       render("]");
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.Var)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.Var _var = (com.biosimilarity.lift.model.vorpal.Absyn.Var) foo;
       render("(");
       render("Var");
       sh(_var.ident_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitInt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitInt _litint = (com.biosimilarity.lift.model.vorpal.Absyn.LitInt) foo;
       render("(");
       render("LitInt");
       sh(_litint.integer_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitChar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitChar _litchar = (com.biosimilarity.lift.model.vorpal.Absyn.LitChar) foo;
       render("(");
       render("LitChar");
       sh(_litchar.char_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitString)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitString _litstring = (com.biosimilarity.lift.model.vorpal.Absyn.LitString) foo;
       render("(");
       render("LitString");
       sh(_litstring.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.LitDouble)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.LitDouble _litdouble = (com.biosimilarity.lift.model.vorpal.Absyn.LitDouble) foo;
       render("(");
       render("LitDouble");
       sh(_litdouble.double_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.List)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.List _list = (com.biosimilarity.lift.model.vorpal.Absyn.List) foo;
       render("(");
       render("List");
       render("[");
       sh(_list.listexp_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListExp foo)
  {
     for (java.util.Iterator<Exp> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListString foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListRHS foo)
  {
     for (java.util.Iterator<RHS> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.RHS foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RHS)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RHS _rhs = (com.biosimilarity.lift.model.vorpal.Absyn.RHS) foo;
       render("(");
       render("RHS");
       render("[");
       sh(_rhs.listitem_);
       render("]");
       render(")");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.MinimumSize foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.MNonempty)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.MNonempty _mnonempty = (com.biosimilarity.lift.model.vorpal.Absyn.MNonempty) foo;
       render("MNonempty");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.MEmpty)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.MEmpty _mempty = (com.biosimilarity.lift.model.vorpal.Absyn.MEmpty) foo;
       render("MEmpty");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.Reg foo)
  {
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RSeq)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RSeq _rseq = (com.biosimilarity.lift.model.vorpal.Absyn.RSeq) foo;
       render("(");
       render("RSeq");
       sh(_rseq.reg_1);
       sh(_rseq.reg_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAlt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAlt _ralt = (com.biosimilarity.lift.model.vorpal.Absyn.RAlt) foo;
       render("(");
       render("RAlt");
       sh(_ralt.reg_1);
       sh(_ralt.reg_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RMinus)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RMinus _rminus = (com.biosimilarity.lift.model.vorpal.Absyn.RMinus) foo;
       render("(");
       render("RMinus");
       sh(_rminus.reg_1);
       sh(_rminus.reg_2);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RStar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RStar _rstar = (com.biosimilarity.lift.model.vorpal.Absyn.RStar) foo;
       render("(");
       render("RStar");
       sh(_rstar.reg_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RPlus)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RPlus _rplus = (com.biosimilarity.lift.model.vorpal.Absyn.RPlus) foo;
       render("(");
       render("RPlus");
       sh(_rplus.reg_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.ROpt)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.ROpt _ropt = (com.biosimilarity.lift.model.vorpal.Absyn.ROpt) foo;
       render("(");
       render("ROpt");
       sh(_ropt.reg_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.REps)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.REps _reps = (com.biosimilarity.lift.model.vorpal.Absyn.REps) foo;
       render("REps");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RChar)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RChar _rchar = (com.biosimilarity.lift.model.vorpal.Absyn.RChar) foo;
       render("(");
       render("RChar");
       sh(_rchar.char_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAlts)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAlts _ralts = (com.biosimilarity.lift.model.vorpal.Absyn.RAlts) foo;
       render("(");
       render("RAlts");
       sh(_ralts.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RSeqs)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RSeqs _rseqs = (com.biosimilarity.lift.model.vorpal.Absyn.RSeqs) foo;
       render("(");
       render("RSeqs");
       sh(_rseqs.string_);
       render(")");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RDigit)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RDigit _rdigit = (com.biosimilarity.lift.model.vorpal.Absyn.RDigit) foo;
       render("RDigit");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RLetter)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RLetter _rletter = (com.biosimilarity.lift.model.vorpal.Absyn.RLetter) foo;
       render("RLetter");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RUpper)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RUpper _rupper = (com.biosimilarity.lift.model.vorpal.Absyn.RUpper) foo;
       render("RUpper");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RLower)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RLower _rlower = (com.biosimilarity.lift.model.vorpal.Absyn.RLower) foo;
       render("RLower");
    }
    if (foo instanceof com.biosimilarity.lift.model.vorpal.Absyn.RAny)
    {
       com.biosimilarity.lift.model.vorpal.Absyn.RAny _rany = (com.biosimilarity.lift.model.vorpal.Absyn.RAny) foo;
       render("RAny");
    }
  }

  private static void sh(com.biosimilarity.lift.model.vorpal.Absyn.ListIdent foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

