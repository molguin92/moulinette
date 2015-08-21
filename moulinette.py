__author__ = 'arachnid92'

from importlib import import_module
from subprocess import Popen, PIPE, TimeoutExpired
import sys



def eval ( package_name, main_class, test_input, test_output, max_runtime ):

    print ( 'Evaluating ' + package_name + '.' + main_class + '...\n' )
    program = Popen( ('/usr/bin/java', package_name + '.' + main_class), stdin=PIPE, stderr=PIPE, stdout=PIPE, universal_newlines=True)

    try:
        out, err = program.communicate( input=test_input, timeout=max_runtime)
    except TimeoutExpired:
        program.kill()
        print( 'Timeout exceeded.' )
        return -1

    if program.returncode != 0:
        print( 'Non-zero returncode. Error in execution. \n' )
        print('Dumping STDERR: \n')
        print( err )
        print( '\n\n' )
        print('Dumping STDOUT: \n')
        print( out )
        print( '\n\n' )
        return -1

    #TODO: Test cases longer than one line.

    correct_lines = test_output.splitlines()
    test_lines = out.splitlines()

    for i in range( len(correct_lines) ):
        print ( 'Test case {0}: '.format(i + 1))

        if test_lines[i] == correct_lines[i]:
            print ( 'Correct!\n' )
        else:
            print ( 'Incorrect!\n' )