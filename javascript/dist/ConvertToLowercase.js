"use strict";
function convertToLowerCase(str) {
    let length = str.length;
    let smallString = "";
    for (let i = 0; i < length; i++) {
        let val = str.charCodeAt(i);
        let smallVal = 97;
        if (val >= 65 && val <= 90) {
            console.log("val is : ", str[i], ': ', val - 65);
            let value = smallVal + (val - 65);
            smallString = smallString + String.fromCharCode(value);
            console.log("small Vale is ", String.fromCharCode(value));
        }
        else {
            smallString = smallString + str[i];
        }
        console.log(smallString);
    }
    console.log('Final Output : ', smallString);
}
convertToLowerCase('MACD');
// console.log(String.fromCharCode(122))
//65 = A
//90 = Z
//97 = a 
//122 = z
