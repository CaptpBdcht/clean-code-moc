import UIKit

class Range{
    var start : Int
    var end : Int
    var borneStart : String
    var borneEnd : String
    
    init(borneStrat:String,start:Int,end:Int, borneEnd:String) {
        self.borneStart = borneStrat
        self.start = start
        self.end = end
        self.borneEnd = borneEnd
    }
    
    func contains(number: Int)->Bool{
        var result = true
        if self.borneStart == "(" &&  self.borneEnd == ")"{
            if self.start<number && number<self.end {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "[" &&  self.borneEnd == "]"{
            if self.start<=number && number<=self.end {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "(" &&  self.borneEnd == "]"{
            if self.start<number && number<=self.end {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "[" &&  self.borneEnd == ")"{
            if self.start<=number && number<self.end {
                result = true
            }else{
                result = false
            }
        }
        
        return result
        
    }
    func size()->Int{
        var count = 0
        if self.borneStart == "(" &&  self.borneEnd == ")"{
            count = -1
            return count+end-start
        }
        if self.borneStart == "[" &&  self.borneEnd == "]"{
            count = 1
            return count+end-start
        }
        if self.borneStart == "(" &&  self.borneEnd == "]"{
            return end-start
        }
        if self.borneStart == "[" &&  self.borneEnd == ")"{
            return end-start
        }
        return count
    }
    func values()->[Int]{
        var listofvalue :[Int] = []
        
        if self.borneStart == "(" &&  self.borneEnd == ")"{
            for i in start+1...end-1 {
                listofvalue.append(i)
            }
        }
        if self.borneStart == "[" &&  self.borneEnd == "]"{
            for i in start...end {
                listofvalue.append(i)
            }
        }
        if self.borneStart == "(" &&  self.borneEnd == "]"{
            for i in start+1...end {
                listofvalue.append(i)
            }
        }
        if self.borneStart == "[" &&  self.borneEnd == ")"{
            for i in start...end-1 {
                listofvalue.append(i)
            }
        }
        
        return listofvalue
    }
    
    func endpoint()->[Int]{
        var listofvalue :[Int] = []
        
        if self.borneStart == "(" &&  self.borneEnd == ")"{
            listofvalue.append(start+1)
            listofvalue.append(end-1)
        }
        if self.borneStart == "[" &&  self.borneEnd == "]"{
            listofvalue.append(start)
            listofvalue.append(end)
        }
        if self.borneStart == "(" &&  self.borneEnd == "]"{
            listofvalue.append(start+1)
            listofvalue.append(end)
        }
        if self.borneStart == "[" &&  self.borneEnd == ")"{
            listofvalue.append(start)
            listofvalue.append(end-1)
        }
        
        return listofvalue
    }
    
    func interval(interval: Range)->Bool{
        var result = true
        if self.borneStart == "(" &&  self.borneEnd == ")"{
            if (self.start<interval.start && interval.start<self.end) && (self.start<interval.end && interval.end<self.end) {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "[" &&  self.borneEnd == "]"{
            if (self.start<=interval.start && interval.start<=self.end) && (self.start<=interval.end && interval.end<=self.end) {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "(" &&  self.borneEnd == "]"{
            if (self.start<interval.start && interval.start<self.end) && (self.start<=interval.end && interval.end<=self.end) {
                result = true
            }else{
                result = false
            }
        }
        else if self.borneStart == "[" &&  self.borneEnd == ")"{
            if (self.start<=interval.start && interval.start<=self.end) && (self.start<interval.end && interval.end<self.end) {
                result = true
            }else{
                result = false
            }
        }
        
        return result
    }
}

var rangecontain = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangecontain.contains(number: 23)) //false

var rangecontain2 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:")")
print(rangecontain2.contains(number: 7)) //false

var rangecontain3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangecontain3.contains(number: 6)) //true

var rangecontain4 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangecontain4.contains(number: 3)) //true

var rangesize = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")
print(rangesize.size()) //5

var rangesize2 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:")")
print(rangesize2.size()) //3

var rangesize3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangesize3.size()) //4

var rangesize4 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:"]")
print(rangesize4.size()) //4

var rangevalues = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")
print(rangevalues.values()) //3,4,5,6,7

var rangevalues2 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:")")
print(rangevalues2.values()) //4,5,6

var rangevalues3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangevalues3.values()) //3,4,5,6

var rangevalues4 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:"]")
print(rangevalues4.values()) //4,5,6,7

var rangeendpoint = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")
print(rangeendpoint.endpoint()) //[3,7]

var rangeendpoint2 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:")")
print(rangeendpoint2.endpoint()) //[4,6]

var rangeendpoint3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
print(rangeendpoint3.endpoint()) //[3,6]

var rangeendpoint4 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:"]")
print(rangeendpoint4.endpoint()) //[4,7]

var rangeinterval = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")
var rangeintervaltest = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")

print(rangeinterval.interval(interval:rangeintervaltest)) //true

var rangeinterval2 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:")")
var rangeintervaltest2 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")

print(rangeinterval2.interval(interval:rangeintervaltest)) //false

var rangeinterval3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:")")
var rangeintervaltest3 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")

print(rangeinterval3.interval(interval:rangeintervaltest)) //false

var rangeinterval4 = Range(borneStrat:"(", start: 3,end:7 ,borneEnd:"]")
var rangeintervaltest4 = Range(borneStrat:"[", start: 3,end:7 ,borneEnd:"]")

print(rangeinterval4.interval(interval:rangeintervaltest)) //false
