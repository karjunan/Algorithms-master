//cinema
//iceman
// 

function anagram(input, input1) {
    input = input.split("").sort();
    console.log(input);
    input1 = input1.split("").sort();
    console.log(input1);

    for( let i in input) {
        if(input[i] == input1[i]) {
            continue;
        } else {
            return false;
        }
    }
    
    return true;
}

function anagramV1(input , input1) {
    if(input.length != input1.length) {
        return false;
    }
    var inputMap = {};
    for(let i = 0 ; i < input.length; i++) {
        if(inputMap[input[i]]) {
            inputMap[input[i]] = inputMap[input[i]] + 1;
        } else {
            inputMap[input[i]] = 1;
        }
        console.log(inputMap);
    }

    for(let i in input1) {
        if(inputMap[input1[i]]) {
            let val = inputMap[input1[i]];
            if( val > 0 ) {
                inputMap[input1[i]] = val-1;
            } else {
                
                delete inputMap[input1[i]];
            }
        } else {
            return false;
        }
    }
    return true;
}

let result = anagramV1('abc', 'bac')

console.log(result);

export {anagram, anagramV1}