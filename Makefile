define ANNOUNCE
You can run this file with:
- clean
- compile
- run
endef

export ANNOUNCE

all:
	@echo "$$ANNOUNCE"

compile-no-debug:
	javac -d . src/*.java

compile:
	javac -d . -g src/*.java

clean:
	rm *.class

run:
	@java -XX:+ShowCodeDetailsInExceptionMessages TestRunner
