all:
	happy -gca ParBNF.y
	alex -g LexBNF.x
	latex DocBNF.tex; dvips DocBNF.dvi -o DocBNF.ps
	ghc --make TestBNF.hs -o TestBNF
clean:
	-rm -f *.log *.aux *.hi *.o *.dvi
	-rm -f DocBNF.ps
distclean: clean
	-rm -f DocBNF.* LexBNF.* ParBNF.* LayoutBNF.* SkelBNF.* PrintBNF.* TestBNF.* AbsBNF.* TestBNF ErrM.* SharedString.* BNF.dtd XMLBNF.* Makefile*

