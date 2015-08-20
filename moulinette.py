__author__ = 'arachnid92'

from importlib import import_module
import sys



def eval ( path_to_program, input, output ):

    try:
        handler = import_module(path_to_program + '.handler')
        Module = getattr(handler, 'Module')
    except ImportError:
        print ( 'No such program module.', file=sys.stderr )
        return None

    module = Module()

    module.start()

