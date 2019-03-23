from chatterbot.trainers import ListTrainer
from chatterbot import ChatBot
import os


class Bot:

	bot = ChatBot('Teste')
	trainer = ListTrainer(bot)

	def constroiBot(self):

		

		for arq in os.listdir('../../arquivo'):

			chats = open('../../arquivo/'+arq, 'r').readlines()
			self.trainer.train(chats)

	def conversaBot(self,msg):

	# while True:
		#resq = input('Você: ')
		resp = self.bot.get_response(msg)
		#print('Bot: ', resp)
		return "%s"%resp


















