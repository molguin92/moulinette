__author__ = 'arachnid92'

from moulinette import java_eval

package = 'test'
mainclass = 'HelloWorld'
test_input = ''
test_output = 'Hello World!\n'

java_eval(package,mainclass,test_input,test_output,max_runtime=1)