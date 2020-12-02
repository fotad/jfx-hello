#! /bin/sh

if [ -z "$GRAALVM_HOME" ]; then
	GRAALVM_HOME=$HOME/tools/graalvm
fi

if [ "$1" = "-native" ]; then
	#seems native image can't handle link of the symbolic link
	OpenJFX=/usr/share/java
	OpenJFX_CP=$OpenJFX/javafx-base.jar:$OpenJFX/javafx-graphics.jar:$OpenJFX/javafx-controls.jar
	$GRAALVM_HOME/bin/native-image -cp bin:res:$OpenJFX_CP demo.Hello
else
	OpenJFX=/usr/share/openjfx/lib
	$GRAALVM_HOME/bin/javac --module-path $OpenJFX --add-modules=javafx.controls -d bin -sourcepath src src/demo/Hello.java
fi
