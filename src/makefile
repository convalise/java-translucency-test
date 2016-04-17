all:
	javac com/convalise/lib/*.java com/convalise/translucencytest/*.java

run:
	java com/convalise/translucencytest/Main
	
jar:
	jar cfm TranslucencyTest.jar manifest.mf com/convalise/lib/*.class com/convalise/translucencytest/*.class

clean:
	rm com/convalise/lib/*.class com/convalise/translucencytest/*.class
