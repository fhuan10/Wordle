# Android Project 1 - Wordle

Submitted by: Flora Huang

Wordle is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: 6 hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User has 3 chances to guess a random 4 letter word**
- [X] **After 3 guesses, user should no longer be able to submit another guess**
- [X] **After each guess, user sees the "correctness" of the guess**
- [X] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle betweeen different word lists
- [ ] User can see the 'correctness' of their guess through colors on the word 
- [ ] User sees a visual change after guessing the correct word
- [ ] User can tap a 'Reset' button to get a new word and clear previous guesses
- [ ] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![z8Duzc7](https://user-images.githubusercontent.com/99567644/190613637-5f9f9baf-881c-44c0-9d17-2140f67888d1.gif)


<!-- Replace this with whatever GIF tool you used! -->
GIF created with LicCap 
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Few challenges I came across when creating the Wordle app:
  1. When I run the emulator, the app always crashes the moment it opens, giving an error that the app can't be opened. A hunch of mine is that
     I might have too many variables declared inside the MainActivity class but outside of onCreate function. So instead, I put most of my variables
     inside the onCreate function, and when I run the emulator again, the app succesfully works.
  2. I struggled on how to hide the keyboard after the user submit their guess. I looked around in StackOverflow, and try to make sense of the code
     the developers wrote.
  3. I wanted to create a function that can display certain text on-screen, for example, displaying the user's first guess and result. I thought
     using strings to build the id name with the count variable. I tried to convert the strings into int, so that I could call less amount of variables
     that map to the 'view' elements. But, errors arise when I ran the app, so I ended up declaring all variables that are mapped to the 'view' elements,
     in order to display certain text.
     

## License

    Copyright [2022] [Flora Huang]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
