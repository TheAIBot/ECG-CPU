#!/bin/bash

if [[ -z $1 ]]; then
	java -jar UCIC.jar program.uci
else
	if [[ -z $2 ]]; then
		java -jar UCIC.jar $1 program.asm
	else
		java -jar UCIC.jar $1 $2
	fi
fi