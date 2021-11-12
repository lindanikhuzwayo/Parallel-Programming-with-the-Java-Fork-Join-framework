#Makefile for Assignment1
#Lindani Khuzwayo

JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin


$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<



CLASSES= Median.class Main.class MainSequential.class
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
 

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class


runMain: $(CLASS_FILES)
	java -cp $(BINDIR) Main


runMainS: $(CLASS_FILES)
	java -cp $(BINDIR) MainSequential 

