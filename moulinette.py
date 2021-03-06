import os

__author__ = 'arachnid92'

from importlib import import_module
from subprocess import Popen, PIPE, TimeoutExpired
import sys


def java_eval(package_name, main_class, test_input, test_output, max_runtime):
    # print ( 'Evaluating ' + package_name + '.' + main_class + '...\n' )
    program = Popen('/usr/bin/java ' + package_name + '.' + main_class, stdin=PIPE, stderr=PIPE, stdout=PIPE,
                    universal_newlines=True, shell=True)

    try:
        out, err = program.communicate(input=test_input, timeout=max_runtime)
    except TimeoutExpired:
        program.kill()
        # print( 'Timeout exceeded.' )
        return -1

    if program.returncode != 0:
        sys.stdout.write(err)
        sys.stdout.write('\n')
        return -1

    # TODO: Test cases longer than one line.

    correct_lines = test_output.splitlines()
    test_lines = out.splitlines()
    correct = 1

    if len(correct_lines) != len(test_lines):
        print('\tIncorrect number of output lines. Correct: {0}, got {1}.'.format(len(correct_lines), len(test_lines)))
        print('Correct lines: ')
        for line in correct_lines:
            print(line)
        print('\nGot: ')
        for line in test_lines:
            print(line)
        print('\n\n ')
        return 0

    for i in range(len(correct_lines)):
        # print ( 'Test case {0}: '.format(i + 1))

        if test_lines[i].strip() != correct_lines[i].strip():
            print('\n\t\t\tIncorrect output, line {0}. Expected: {1} \t Got: {2}'.format(i, correct_lines[i].strip(),
                                                                                         test_lines[i].strip()), end='')
            correct = 0

    return correct


def eval_homework(course_code='cc3001', homework_id='tarea3', parts=2):
    inputs = os.listdir(path=('./inputs/' + course_code + '/' + homework_id + '/'))
    outputs = os.listdir(path=('./outputs/' + course_code + '/' + homework_id + '/'))
    inputs.sort()
    outputs.sort()

    if len(inputs) != len(outputs):
        sys.stderr.write('Number of inputs and outputs must match!')
        sys.exit(status=1)
    elif len(inputs) != parts or len(outputs) != parts:
        sys.stderr.write('Each Part must have input and output!')
        sys.exit(status=1)

    alumni = os.listdir(path=('./submissions/' + course_code + '/' + homework_id + '/'))
    alumni.sort()

    os.chdir('./submissions/' + course_code + '/' + homework_id)
    # compile!
    print('Compiling...')
    for student in alumni:
        print('\t' + student, end='... ')
        os.chdir(student)
        program = Popen('/usr/bin/javac *.java -encoding latin1', shell=True, stdin=PIPE, stderr=PIPE, stdout=PIPE,
                        universal_newlines=True)
        out, err = program.communicate()

        if program.returncode != 0:
            print('Error when compiling submission.\n')
            sys.stdout.write(err)
            sys.stderr.write('\n')
        else:
            print('Compiled correctly.\n')
        os.chdir('..')

    os.chdir('../../../')

    # parse inputs and outputs into strings
    pinputs = []
    poutputs = []
    for input in inputs:
        file = open(('./inputs/' + course_code + '/' + homework_id + '/' + input), mode='r')
        pinputs.append(file.read())
    for output in outputs:
        file = open(('./outputs/' + course_code + '/' + homework_id + '/' + output), mode='r')
        poutputs.append(file.read())

    # run!
    os.chdir('./submissions')
    print('Evaluating...')
    pkg_suffix = course_code + '.' + homework_id + '.'
    for student in alumni:
        print('\n\tEvaluating ' + student)
        i = 0
        while i < parts:
            print('\n\t\tPart' + str(i + 1), end='... ')
            ret = java_eval(pkg_suffix + student, 'Parte' + str(i + 1), pinputs[i], poutputs[i], 1)
            if ret == 1:
                print('Correct \u2713')
            elif ret == -1:
                print('Error in execution.')
            i += 1

    os.chdir('..')
