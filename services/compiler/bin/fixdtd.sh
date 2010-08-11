#! /bin/sh

sed -e 's/<!DOCTYPE .* \[//' -e 's/\]>//' -e 's/(EMPTY)/EMPTY/' -e 's/standalone="yes"/encoding="UTF-8"/' $1.dtd > $1p.dtd