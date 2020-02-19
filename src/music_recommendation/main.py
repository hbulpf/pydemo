import os
from flask import Flask, request, render_template, Markup

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
@app.route('/index.html', methods=['GET', 'POST'])
def recommendation1():
  if request.method == 'GET':
    return render_template('index.html', input_text = '', res_text = '')
  else:
    inputText = request.form.get("input_text")
    resText = Markup(formatRes(reverseText(inputText)))
    return render_template('index.html', input_text = inputText, res_text = resText)

@app.route('/rec2.html', methods=['GET', 'POST'])
def recommendation2():
  if request.method == 'GET':
    return render_template('rec2.html', input_text = '', res_text = '')
  else:
    inputText = request.form.get("input_text")
    resText = Markup(formatRes(reverseText(inputText)))
    return render_template('rec2.html', input_text = inputText, res_text = resText)

@app.route('/rec3.html', methods=['GET', 'POST'])
def recommendation3():
  if request.method == 'GET':
    return render_template('rec3.html', input_text = '', res_text = '')
  else:
    inputText = request.form.get("input_text")
    resText = Markup(formatRes(reverseText(inputText)))
    return render_template('rec3.html', input_text = inputText, res_text = resText)

@app.route('/rec4.html', methods=['GET', 'POST'])
def recommendation4():
  if request.method == 'GET':
    return render_template('rec4.html', input_text = '', res_text = '')
  else:
    inputText = request.form.get("input_text")
    resText = Markup(formatRes(reverseText(inputText)))
    return render_template('rec4.html', input_text = inputText, res_text = resText)

def formatRes(textList):
  return '<p>' + '</p><p>'.join(textList) + '</p>'

# A sample
def reverseText(text):
  res = []
  res.append('Original text: %s' %(text))
  res.append('Converted text: %s' %(''.join(reversed(list(text)))))
  return res

if __name__ == '__main__':
    app.run(host='0.0.0.0',port='5000')