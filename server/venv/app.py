from flask import Flask
from chatbot import Bot

app = Flask(__name__)

classBot = Bot() 
classBot.constroiBot()

@app.route('/bot/<msg>')
def bot(msg):
    return classBot.conversaBot(msg)

app.run(host= "0.0.0.0", port="5000")
