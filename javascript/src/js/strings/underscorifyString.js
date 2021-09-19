function underscorifySubstring(str, substring) {
    console.log(str,substring);
    var array = getLocations(str,substring)
    
    var resultarray = mergeLocation(array);
    // var finalString = provideUnderScore(resultarray, str);
    return "";
}

function provideUnderScore(array, str) {

        var temp = [];
        var k = 0;
        for(var i = 0 ; i < array.length+1; i++) {
                var brokenString = str.substring(k,array[i]);
                temp.push(brokenString);
                k = array[i];
                console.log("BrokenString " + brokenString)
        }

  
       var finalString = "";
       for(var i = 0; i < temp.length; i++) {
           finalString = finalString+temp[i]+"_"; 
           console.log(finalString)
       }
       finalString = finalString.substring(0,finalString.length-1);
       console.log("Output => " + finalString)
       
       return finalString;
}

function mergeLocation(array) {
    
    for( var i = 0 ; i< array.length - 1; i++) {
        if(array[i] === array[i+1]) {
            array[i] = null;
            array[i+1] = null;
            i++;
        }

    }
    var temp = [];
    for(var i = 0 ; i < array.length; i++) {
        if(array[i] !== null) {
            temp.push(array[i]);
        }  
    }
     console.log(temp);
     return temp;
}

function getLocations(str,substring) {
    var locations = []
    for(var i = 0 ; i < str.length; i++) {
          var index = str.indexOf(substring,i);
          locations.push(index);
          if(index > length) {
              i = index;
          }
          var length = index + substring.length;
          locations.push(length);
         console.log("Index location => ", index, length)
    }
    // console.log(locations)
    return locations;
}
// function getLocations(str , substring) {
//      var locations = []
//      var i = 0
//      var j = 0;
//      while(i < str.length) {
//           if(str[i] === substring[j]) {
//              console.log(" match -> " , i , j , str[i], substring[j])
//               i++;
//               j++;
//               if(j === substring.length) {
//                 locations.push(i-j);
//                 locations.push(i);   
//                 console.log("Match found", (i-j), i,str[i],substring[j-1]);  
//               } 
//               continue;
//           }

//           if(j == 0) {
//               i++;
//           }

         
//           j = 0    
//      }
//      console.log(locations)
//      return locations;
// }

let str = "testthis is a testtest to see if testestest it works";
// let str = "abcabcabcabcabcabcabcabcabcabcabcabcabcabc"
// let str = "abababababababababababababaababaaabbababaa";
// let str = "this test is a mack code test to see if it works "
let substring = "test"
// let substring = "abc"
// let substring = "a";

let result = underscorifySubstring(str,substring)
console.log("Finally output => ", result)