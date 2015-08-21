__author__ = 'arachnid92'

from moulinette import eval

package = 'test'
mainclass = 'HelloWorld'
test_input = ''
test_output = 'Hello World!\n'

eval(package,mainclass,test_input,test_output,max_runtime=1)