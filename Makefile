SHELL := /usr/bin/env bash

all: test

.PHONY: test
test:
	@mvn clean test

.PHONY: package
package:
	@mvn clean package