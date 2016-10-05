#!/bin/bash
cat CPU/*.fdl > whole-CPU.fdl
fdlsim whole-CPU.fdl $1