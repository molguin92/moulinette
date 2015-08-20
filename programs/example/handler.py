__author__ = 'arachnid92'

from threading import Thread
from os import system

class Module ( Thread ):

    def __init__(self, arguments = ''):
        Thread.__init__(self)

        system( '/usr/bin/javac Example.java' )
        self.arguments = arguments

    def run(self):
        