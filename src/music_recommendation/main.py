import os
from flask import Flask, request, render_template, Markup
import musiccore

app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def demo():
  if request.method == 'GET':
    return render_template('index.html', input_text = '', res_text = '')
  else:
    inputText = request.form.get("input_text")
    resText = Markup(formatRes(reverseText(inputText)))
    return render_template('index.html', input_text = inputText, res_text = resText)

def formatRes(textList):
  return '<p>' + '</p><p>'.join(textList) + '</p>'

# A sample
def reverseText(text):
  res = []
  res.append('Original text: %s' %(text))
  res.append('Converted text: %s' %(''.join(reversed(list(text)))))
  return res

if __name__ == '__main__':
    app.run(host='0.0.0.0')