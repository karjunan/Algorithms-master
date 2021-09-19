function longestCommonSubsequence(str1,str2) {
    console.log("Input Value = > " , str1,str2);
    var matrix = buildMatrix(str1,str2);
    var row = matrix.length;
    var col = matrix[0].length;
     row = row;
     col = col;
    for(var i = 2; i < row; i++) {
        console.log("Starting one row =>>>>>>>>>>>>>>>>>>>")
        for(var j = 2; j < col; j++) {
            console.log('Values compared => ', matrix[i][0], matrix[0][j])
            if(matrix[i][0] !== matrix[0][j]) {
                if(matrix[i-1][j].length > matrix[i][j-1].length) {
                     matrix[i][j] = matrix[i-1][j];
                } else {
                    matrix[i][j] = matrix[i][j-1];
                }
                console.log("No match , current value => ", matrix[i][j])
            } else {
                matrix[i][j] = matrix[i-1][j-1].concat(matrix[i][0]);
                console.log("There is a match , current value => ", matrix[i][j])
            }
        }
    }

    var result = matrix[row-1][col-1];
    var temp = []
    for(var i of result) {
        temp.push(i);
    }
    return temp;

}

function buildMatrix(str1,str2) {
   var matrix = []
   var k = 0
    for(var i = 0; i < str2.length + 2; i++) {
        var temp = new Array(str1.length);
        if(i < 2) {
            temp[0] = '';
        } else {
            temp[0] = str2[k];
            temp[1] = '';
            k++;
        }
        matrix.push(temp);
        
    }

    k = 0
    matrix[0][1] = '';
    matrix[1][1] = '';
    for(var i = 2; i < str1.length + 2; i++) {
        matrix[0][i] = str1[k++];
        matrix[1][i] = ''; 
    }
    //console.log(matrix)
    return matrix;
}


let str1 = "clement"
let str2 = "antoine"
// let str1 = "ZXVVYZW"
// let str2 = "XKYKZPW"

let result = longestCommonSubsequence(str1,str2);
console.log('The result is => ' , result)