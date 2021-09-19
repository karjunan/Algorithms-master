function naiveStringSearch(string1, string2) {

    var str1i = 0;
    var str1j = 0;

    var str2i = 0;
    
    var found = [];

    while( str1j < string1.length && str1i < string1.length) {

        if(string1[str1i] != string2[str2i]) {
            str1i++;
            continue;
        }

        str1j = str1i
        
        while(string1[str1j] == string2[str2i] 
            && str2i < string2.length 
            && str1j < string1.length) {
            str1j++;
            str2i++;
        }

        if(str2i == string2.length) {
            console.log("Found an match => " + string2)
            var val = {};
            val.first = str1i;
            val.second = str1j-1
            found.push(val);
            str1i = str1j;
        } 
        str1i++;
        str2i = 0;
        // console.log(str1i , str1j)
    }
    return found;
}


let string1='howreouhello are we goodhowhello' 
let string2='hello'
let result = naiveStringSearch(string1,string2);
console.log(result);