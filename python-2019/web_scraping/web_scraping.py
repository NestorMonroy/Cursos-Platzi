import requests
from bs4 import BeautifulSoup
from urllib.request import urlretrieve
from datetime import datetime, date, time, timedelta


def run():
	comics_amount = int(input('How many days have you been without reading comics?\nA// '))

	today = date.today()
	
	for i in range (0, comics_amount):
		comic_day = today - timedelta(days = i)
 
		inside_url = requests.get('http://www.gocomics.com/reallifeadventures/{}/{}/{}'.format(comic_day.year,comic_day.month,comic_day.day))
		url_html = BeautifulSoup(inside_url.content, 'html.parser')
		image_container = url_html.find('picture',{'class':'item-comic-image'})
		
		image_url = image_container.find('img')['src']
		image_name = 'reallifeadventures{}.{}.{}.jpg'.format(comic_day.year,comic_day.month,comic_day.day)
		print('Downloading the image {}'.format(image_name))
		urlretrieve('{}'.format(image_url), image_name)

	print ('\nSuccesfull Download')


if __name__ == '__main__':
	run()


# def run():
#     for i in range(1,6):
#         response = requests.get('https://xkcd.com/{}'.format(i))
#         soup = BeautifulSoup(response.content, 'html.parser')
#         image_container = soup.find(id='comic')        

#         image_url = image_container.find('img')['src']
#         image_name = image_url.split('/')[-1]
#         print('Descargando la imagen {}'.format(image_name))
#         urlretrieve('https:{}'.format(image_url), image_name)

# if __name__ == "__main__":
#     run()