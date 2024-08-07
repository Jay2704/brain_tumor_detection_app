# Brain Tumor Detection Project

This repository contains the code and resources for a brain tumor detection project. The project includes a machine learning model for detecting brain tumors from MRI images and an Android application to provide a user interface for the model.

## Project Description

The Brain Tumor Detection project aims to leverage deep learning techniques to accurately identify brain tumors from MRI images. The project consists of two main components:
1. A machine learning model developed using Python and Jupyter Notebook.
2. An Android application developed in Java to interface with the model and provide a user-friendly experience.

## Repository Contents

- `MDP Project.ipynb`: A Jupyter Notebook containing the machine learning model for brain tumor detection.
- `model.tflite`: A TensorFlow Lite model file used in the Android application for on-device inference.
- `MainActivity.java`: The main activity file for the Android application, responsible for integrating the machine learning model and handling user interactions.

## Machine Learning Model

The machine learning model is developed using Python and various deep learning libraries. The model is trained on MRI images to detect the presence of brain tumors. The steps involved in the development of the model include:

1. **Data Preprocessing**: Loading and preprocessing MRI images.
2. **Model Architecture**: Designing a convolutional neural network (CNN) for image classification.
3. **Training**: Training the model on a dataset of labeled MRI images.
4. **Evaluation**: Evaluating the model's performance on a validation set.
5. **Export**: Converting the trained model to TensorFlow Lite format for use in the Android application.

The Jupyter Notebook `MDP Project.ipynb` contains all the code and explanations for each of these steps.

## Android Application

The Android application provides a user interface for users to interact with the brain tumor detection model. The main features of the application include:

1. **Image Input**: Allowing users to upload or capture MRI images using the device's camera.
2. **Model Integration**: Loading the TensorFlow Lite model and running inference on the input images.
3. **Results Display**: Displaying the detection results to the user, indicating the presence or absence of a brain tumor.

The main activity file `MainActivity.java` includes the necessary code to integrate the TensorFlow Lite model and handle user interactions.

## Getting Started

To run this project locally, follow these steps:

### Prerequisites

- Python 3.x
- Jupyter Notebook
- TensorFlow and TensorFlow Lite
- Android Studio
- Android device or emulator

### Instructions

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/brain-tumor-detection.git
   cd brain-tumor-detection

2.	**Machine Learning Model**:
	•	Open the MDP Project.ipynb file in Jupyter Notebook.
	•	Follow the instructions to preprocess the data, train the model, and export the TensorFlow Lite model.

3.	**Android Application**:
	•	Open the project in Android Studio.
	•	Place the model.tflite file in the appropriate directory (app/src/main/assets/).
	•	Connect an Android device or start an emulator.
	•	Build and run the application on the device or emulator.

