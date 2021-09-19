function diskStacking(disks) {
    //console.log(disks);
    if(disks.length === 1) {
        return disks[0];
    }
    var heightArray = [disks.length];
    disks.sort((a,b) => {
        if(a[2] < b[2]) {
            return -1;
        } else if(a[2] > b[2]) {
            return 1;
        } else {
            return 0;
        }
    });

    for(var pos = 0 ; pos < disks.length; pos++) {
        heightArray[pos] = disks[pos][2]
    }

    console.log("height array =>>>>>", heightArray)
    var sequences = [];
    
    for(var i = 1 ; i < disks.length; i++) {
        var height = heightArray[i];
        var positions = [] 
        console.log("Working current index =>>>>> "  , disks[i]);
        for(var j = 0; j < i; j++) {
             var validDisk = validateValidDisk(disks[i],disks[j])
             var sum = heightArray[j] + height;
             if(validDisk && sum > heightArray[i] 
                && heightArray[i] > heightArray[j]
                ) {
                 heightArray[i] = sum;
                 positions.push(disks[j])
                 console.log("height Array after updation  =>>", disks[j],heightArray,heightArray[j], heightArray[i] ,  sum )
             }
            
        }
        positions.push(disks[i]);
        sequences.push(positions);
        // console.log("sequence data => " , sequences)
    }
    var max = 0;
    var j = 0;
    for(var i = 0; i < sequences.length; i++) {
        console.log("sequencees => " , sequences[i])
         if(max < sequences[i].length) {
             max = sequences[i].length
             j = i;
         }
    }
    console.log("j and return max sequences => ", max, j, sequences[j]);
    return sequences[j];
}

function validateValidDisk(disk1, disk2) {
    // console.log("Disk 1  and Disk 2" , disk1 , disk2);
    var bool = [false,false,false]
    
    if(disk1[0] > disk2[0]) {
        bool[0] = true;
    }
    if(disk1[1] > disk2[1]) {
        bool[1] = true;
    }
    if(disk1[2] > disk2[2]) {
        bool[2] = true;
    }
   
    for(var i of bool) {
        if(!i) {
            return false;
        }
        // console.log("i th value " , i , bool)
    }
    console.log("Valid values ", disk1, disk2)
    return true;
}


let array = [[2, 1, 2], [3, 2, 3], [2, 2, 8]]

// let array = [
//     [ 2, 1, 2 ]
//  ]

//  let array = [
//     [ 2, 1, 2 ],
//     [ 3, 2, 3 ],
//     [ 2, 2, 8 ],
//     [ 2, 3, 4 ],
//     [ 1, 3, 1 ],
//     [ 4, 4, 5 ]
//  ]
let result = diskStacking(array) ;
console.log("Result is => ", result)  