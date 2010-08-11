module AbsBNF where

-- Haskell module generated by the BNF converter

newtype Ident = Ident String deriving (Eq,Ord,Show)
data LGrammar =
   LGr [LDef]
  deriving (Eq,Ord,Show)

data LDef =
   DefAll Def
 | DefSome [Ident] Def
 | LDefView [Ident]
  deriving (Eq,Ord,Show)

data Grammar =
   Grammar [Def]
  deriving (Eq,Ord,Show)

data Def =
   Rule Label Cat [Item]
 | Comment String
 | Comments String String
 | Internal Label Cat [Item]
 | Token Ident Reg
 | PosToken Ident Reg
 | Entryp [Ident]
 | Separator MinimumSize Cat String
 | Terminator MinimumSize Cat String
 | Coercions Ident Integer
 | Rules Ident [RHS]
 | Function Ident [Arg] Exp
 | Layout [String]
 | LayoutStop [String]
 | LayoutTop
  deriving (Eq,Ord,Show)

data Item =
   Terminal String
 | NTerminal Cat
  deriving (Eq,Ord,Show)

data Cat =
   ListCat Cat
 | IdCat Ident
  deriving (Eq,Ord,Show)

data Label =
   LabNoP LabelId
 | LabP LabelId [ProfItem]
 | LabPF LabelId LabelId [ProfItem]
 | LabF LabelId LabelId
  deriving (Eq,Ord,Show)

data LabelId =
   Id Ident
 | Wild
 | ListE
 | ListCons
 | ListOne
  deriving (Eq,Ord,Show)

data ProfItem =
   ProfIt [IntList] [Integer]
  deriving (Eq,Ord,Show)

data IntList =
   Ints [Integer]
  deriving (Eq,Ord,Show)

data Arg =
   Arg Ident
  deriving (Eq,Ord,Show)

data Exp =
   Cons Exp Exp
 | App Ident [Exp]
 | Var Ident
 | LitInt Integer
 | LitChar Char
 | LitString String
 | LitDouble Double
 | List [Exp]
  deriving (Eq,Ord,Show)

data RHS =
   RHS [Item]
  deriving (Eq,Ord,Show)

data MinimumSize =
   MNonempty
 | MEmpty
  deriving (Eq,Ord,Show)

data Reg =
   RSeq Reg Reg
 | RAlt Reg Reg
 | RMinus Reg Reg
 | RStar Reg
 | RPlus Reg
 | ROpt Reg
 | REps
 | RChar Char
 | RAlts String
 | RSeqs String
 | RDigit
 | RLetter
 | RUpper
 | RLower
 | RAny
  deriving (Eq,Ord,Show)

