import java.time.LocalDate
import java.time.format.*

fun NhapSoNguyen():Int{
    var n:Int
    do {
        print("Nhập vào số nguyên dương, nếu không đúng vui lòng nhập lại: ")
        n = readln().toInt()
    } while (n < 0)
    return n
}

fun SoNguyenTo(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..n / 2) {
        if (n % i == 0) return false
    }
    return true
}

fun TongSNTTuMotDenN(n:Int):Int{
    var s = 0
    var i = 1
    while (i < n+1){
        if(SoNguyenTo(i))
        {
            s += i
        }
        i++
    }
    return s
}

fun X(n: Int):Double
{
    if (n == 0)
    {
        return 1.0
    }
    return X(n - 1) + Y(n - 1)
}

fun Y(n: Int):Double
{
    if (n == 0)
    {
        return 0.0
    }
    return 3 * X(n - 1) + 2 * Y(n-1)
}

fun BieuThucXY(n:Int)
{
    println("X($n) = ${X(n)}")
    println("Y($n) = ${Y(n)}")
}

fun KTNgay(formatter: DateTimeFormatter): LocalDate? {
    return try
    {
        val input = readLine() ?: ""
        LocalDate.parse(input, formatter)
    }
    catch (e: DateTimeParseException)
    {
        println("Ngày không hợp lệ: ${e.message}")
        null
    }
}

fun NgaySomNhat()
{
    val dinhDangNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    println("Nhập ngày đầu tiên (theo định dạng dd/MM/yyyy):")
    val ngay1 = KTNgay(dinhDangNgay)

    println("Nhập ngày thứ hai (theo định dạng dd/MM/yyyy):")
    val ngay2 = KTNgay(dinhDangNgay)

    if (ngay1 != null && ngay2 != null) {
        val ngaySom = if (ngay1.isBefore(ngay2)) ngay1 else ngay2
        println("Ngày sớm nhất là: ${ngaySom.format(dinhDangNgay)}")
    } else {
        println("Đã xảy ra lỗi khi nhập ngày. Vui lòng kiểm tra định dạng.")
    }
}

fun KT4Den7ChuSo(input: String): Boolean {
    return try {
        val number = input.toInt()
        number in 1000..9999999
    } catch (e: NumberFormatException) {
        false
    }
}

fun SoDoiXung()
{
    println("Nhập một số nguyên dương có từ 4 đến 7 chữ số:")
    val str = readLine()
    if(str != null && KT4Den7ChuSo(str))
    {
        if (str == str.reversed()) {
            println("Số $str là số đối xứng.")
        }
        else {
            println("Số $str không phải là số đối xứng.")
        }
    }
    println("Số nhập vào không hợp lệ hoặc không nằm trong khoảng từ 1000 đến 9999999.")
}



fun main() {
    var chon: Int
    while (true)
    {
        println("MENU")
        println("1. Tính tổng các số nguyên tố từ 1 đến N")
        println("2. Tính số hạng thứ n theo biểu thức X và Y")
        println("3. Ngày sớm nhất trong 2 ngày")
        println("4. Số đối xứng (4 đến 7 chữ số)")
        println("5. Số tiến (4 đến 7 chữ số)")
        println("6. từ 100 đến N có bao nhiêu số đối xứng mà tổng các chữ số chia hết cho 3")
        println("7. Từ 100 đến N có bao nhiêu số tiến mà tổng các chữ số chia hết 5")
        print("Lựa chọn: ")
        chon = readln().toInt()
        when {
            chon == 1 -> print(TongSNTTuMotDenN(NhapSoNguyen()))
            chon == 2 -> print(BieuThucXY(NhapSoNguyen()))
            chon == 3 -> print(NgaySomNhat())
            chon == 4 -> print(SoDoiXung())
            chon == 5 -> print("Điểm trùng gốc toạ độ")
            chon == 6 -> print("Điểm trùng gốc toạ độ")
            chon == 7 -> print("Điểm trùng gốc toạ độ")
            chon == 0 ->
            {
                println("Thoát chương trình")
                return
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
    }
}