function subsequence(str, str1) {
    var i = 0; 
    var j = 0;

    while( i < str.length && j < str1.length) {
        if(str[i] === str1[j]) {
            i++;
            j++;
            continue;
        } 
        if(i == str.length) {
            break;
        }
        j++;
    }
    // console.log(str + "  => "  + str1 )
    if(i < str.length) {
        return false
    }
    return true;
   

}

// let result = subsequence('hello', 'hello world')
// let result = subsequence('sing', 'sting')
// let result = subsequence('abc', 'abracaabadf')
// let result = subsequence('abc', 'acb')

console.log(result)