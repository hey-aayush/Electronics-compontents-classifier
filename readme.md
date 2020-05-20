# Electronics-compontents-classifier
Our team intends to build a object detection model which takes an image either from camera or gallery and returns the best-matched electronics along with its other useful details. Our product will quickly identify the given components and provide useful information.

Problem Statement:Finding any new electronic device ,sensors or equipment, we are always interested in finding out its details in every aspect. Many face issues with a traditional text search engine as many times we areV unaware of its details such as components names, operational voltage etc.

Solution:
We intend to build an image search engine through which we can find name and details of any electronic device at the very instant of seeing it by just using our mobile to 
click a picture of that device. We intend to deploy an offline Deep learning model on our android device as well as on Website to get our desired output. The app will also contain 
many more features.

We used a MobileNetV2 as a pre trained base model and trained it on our custom dataset (downloaded from Kaggle and google images)using CNN architecture and achieved accuracy of 90% .The converted tensorflow model (tflite) is loaded and run by importing tensorflow library in android app. For deployment of web model we used a Flask app for hosting website. 

Features of android app:

1. Search by capturing the image or browsing from gallery.
2. Search by text and also can explore whole list.
3. Search the name of components is also possible in offline mode.
4. Provide various platforms for buying the product in a single app.
5. Normal features like user verification through email and share the app feture and Rate Us feature.


Demo of this app is in this video, copy and paste the link in browser: 

    https://www.youtube.com/watch?v=V9KzazSmjBs


Various technologies or libraries we used:
1. Deep Learning
2. Android Development
3. Web Development
4TensorFlow
5   . Flask

Database Used: Firebase








