from flask import Flask,request,jsonify
import tensorflow as tf
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing import image
from tensorflow.keras.preprocessing.image import load_img,img_to_array
import numpy as np
import cv2

vgg16=load_model('C:\\Users\\DELL\\models\\VGG16_model.h5')
model = load_model('C:\\Users\\DELL\\models\\complete_model.h5')


def pridiction_images(vgg16,model,content):
    nparr = np.fromstring(content.data, np.uint8)
    img = cv2.imdecode(nparr, cv2.IMREAD_COLOR)
    images=cv2.resize(img,(224,224))
    images = np.expand_dims(images, axis=0)
    images /= 255
    bt_prediction = vgg16.predict(images) 
    preds = model.predict_proba(bt_prediction)
    classes=['Bypass-capacitor', 'Electrolytic-capacitor', 'Integrated-micro-circuit', 'LED', 'PNP-transistor', 'armature', 'attenuator', 'cartridge-fuse', 'clip-lead', 'electric-relay', 'filament', 'heat-sink', 'induction-coil', 'jumper-cable', 'junction-transistor', 'light-circuit', 'limiter-clipper', 'local-oscillator', 'memory-chip', 'microchip', 'microprocessor', 'multiplexer', 'omni-directional-antenna', 'potential-divider', 'potentiometer', 'pulse-generator', 'relay', 'rheostat', 'semi-conductor', 'semiconductor-diode', 'shunt', 'solenoid', 'stabilizer', 'step-down-transformer', 'step-up-transformer', 'transistor']
    class_dictionary = {'Bypass-capacitor': 0,'Electrolytic-capacitor': 1, 'Integrated-micro-circuit': 2, 'LED': 3, 'PNP-transistor': 4, 'armature': 5, 'attenuator': 6, 'cartridge-fuse': 7, 'clip-lead': 8, 'electric-relay': 9, 'filament': 10, 'heat-sink': 11, 'induction-coil': 12, 'jumper-cable': 13, 'junction-transistor': 14,'light-circuit': 15, 'limiter-clipper': 16, 'local-oscillator': 17,'memory-chip': 18, 'microchip': 19, 'microprocessor': 20, 'multiplexer': 21, 'omni-directional-antenna': 22, 'potential-divider': 23, 'potentiometer': 24, 'pulse-generator': 25, 'relay': 26, 'rheostat': 27, 'semi-conductor': 28, 'semiconductor-diode': 29, 'shunt': 30, 'solenoid': 31, 'stabilizer': 32, 'step-down-transformer': 33, 'step-up-transformer': 34, 'transistor': 35}
    class_predicted = model.predict_classes(bt_prediction)

    inv_map = {v: k for k, v in class_dictionary.items()} 
    
    return inv_map[class_predicted[0]]

app=Flask(__name__)

@app.route("/")
def index():
	return'<h1>Flask app is running</h1'


@app.route('/api/image_pridiction',methods=['POST'])

def image_pridiction():

	content=request.json
	results=pridiction_images(vgg16,model,content)
	return jsonify(results)




if __name__ == '__main__':
	app.run()
