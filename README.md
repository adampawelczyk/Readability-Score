# Project Name
> Readability-Score

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Code Example](#code-example)
* [Features](#features)
* [Status](#status)

## General info
Everyone has their own personal reading history, and as we grow up, we are able to comprehend more and more complicated texts. But how do you estimate the level of difficulty of a given text, and how do you teach a computer to do that? In this project I created a program with command-line interface, when we give it a file with text it will print the file content with amount of words, sentences, characters, syllables and polysyllables. Next, program determines how difficult the text is and for which age it is most suitable. It uses several readability tests for this purpose (Automated Readability Index, Flesch–Kincaid readability tests, Simple Measure of Gobbledygook, Coleman–Liau index) . Program can count one or all of them.

## Technologies
* java - version 15.0.1

## Code Example
```
The text is:
This is the front page of the Simple English Wikipedia. Wikipedias are places where people work together to write encyclopedias in different languages. We use Simple English words and grammar here. The Simple English Wikipedia is for everyone! That includes children and adults who are learning English. There are 142,262 articles on the Simple English Wikipedia. All of the pages are free to use. They have all been published under both the Creative Commons License and the GNU Free Documentation License. You can help here! You may change these pages and make new pages. Read the help pages and other good pages to learn how to write pages here. If you need help, you may ask questions at Simple talk. Use Basic English vocabulary and shorter sentences. This allows people to understand normally complex terms or phrases.

Words: 137
Sentences: 14
Characters: 687
Syllables: 230
Polysyllables: 17
Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all

Automated Readability Index: 7.08 (about 14 year olds).
Flesch–Kincaid readability tests: 8.04 (about 15 year olds).
Simple Measure of Gobbledygook: 9.42 (about 16 year olds).
Coleman–Liau index: 10.66 (about 17 year olds).

This text should be understood in average by 15.50 year olds.
```
## Features
List of features
* print the amount of:
    * words
    * sentences
    * syllables
    * polysyllables
* Calculate readability tests by:
    * Automated Readability Index
    * Flesch–Kincaid readability tests
    * Simple Measure of Gobbledygook
    * Coleman–Liau index

## Status
Project is: _finished_