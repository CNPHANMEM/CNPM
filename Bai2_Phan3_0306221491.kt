// Bài 1: Tính tổng các số nguyên tố từ 1 đến N
fun tinhTongSoNguyenTo() {
    print("Nhập số nguyên dương N: ")
    val n = readLine()!!.toInt()
    var tong = 0

    for (i in 2..n) {
        var laNguyenTo = true
        for (j in 2 until i) {
            if (i % j == 0) {
                laNguyenTo = false
                break
            }
        }
        if (laNguyenTo) {
            tong += i
        }
    }
    println("Tổng các số nguyên tố từ 1 đến $n là: $tong")
}

// Bài 2: Tính số hạng thứ n theo biểu thức X và Y
fun tinhSoHang() {
    print("Nhập số nguyên dương N: ")
    val n = readLine()!!.toInt()

    val x = n * 1 - (n - 1)
    val y = 3 + n * 2 - 1

    println("X($n) = $x")
    println("Y($n) = $y")
}

// Bài 3: Nhập vào 2 ngày hợp lệ, cho biết ngày sớm nhất
fun soSanhNgay() {
    print("Nhập ngày, tháng, năm của ngày thứ nhất (dd MM yyyy): ")
    val ngay1 = readLine()!!.split(" ").map { it.toInt() }

    print("Nhập ngày, tháng, năm của ngày thứ hai (dd MM yyyy): ")
    val ngay2 = readLine()!!.split(" ").map { it.toInt() }

    val ngay1Formatted = ngay1[2] * 10000 + ngay1[1] * 100 + ngay1[0]
    val ngay2Formatted = ngay2[2] * 10000 + ngay2[1] * 100 + ngay2[0]

    if (ngay1Formatted < ngay2Formatted) {
        println("Ngày sớm nhất là: ${ngay1.joinToString("/")}")
    } else {
        println("Ngày sớm nhất là: ${ngay2.joinToString("/")}")
    }
}

// Bài 4: Kiểm tra số đối xứng
fun kiemTraSoDoiXung() {
    print("Nhập số nguyên dương có 4 đến 7 chữ số: ")
    val so = readLine()!!

    if (so == so.reversed()) {
        println("$so là số đối xứng")
    } else {
        println("$so không phải là số đối xứng")
    }
}

// Bài 5: Kiểm tra số tiến
fun kiemTraSoTien() {
    print("Nhập số nguyên dương có 4 đến 7 chữ số: ")
    val so = readLine()!!

    val isIncreasing = so.zipWithNext().all { (a, b) -> a < b }

    if (isIncreasing) {
        println("$so là số tiến")
    } else {
        println("$so không phải số tiến")
    }
}

// Bài 6: Đếm số đối xứng chia hết cho 3
fun demSoDoiXungChiaHet3() {
    print("Nhập số nguyên dương có 4 đến 7 chữ số: ")
    val n = readLine()!!.toInt()
    var count = 0

    for (i in 100..n) {
        val so = i.toString()
        if (so == so.reversed()) {
            val sumOfDigits = so.sumOf { it.toString().toInt() }
            if (sumOfDigits % 3 == 0) {
                count++
            }
        }
    }
    println("Có $count số đối xứng mà tổng các chữ số chia hết cho 3 từ 100 đến $n.")
}

// Bài 7: Đếm số tiến chia hết cho 5
fun demSoTienChiaHet5() {
    print("Nhập số nguyên dương có 4 đến 7 chữ số: ")
    val n = readLine()!!.toInt()

    var count = 0

    for (i in 100..n) {
        val so = i.toString()
        val isIncreasing = so.zipWithNext().all { (a, b) -> a < b }
        if (isIncreasing) {
            val sumOfDigits = so.sumOf { it.toString().toInt() }
            if (sumOfDigits % 5 == 0) {
                count++
            }
        }
    }
    println("Có $count số tiến mà tổng các chữ số chia hết cho 3 từ 100 đến $n.")
}

fun menu()
{
    println("==== MENU ====")
    println("1. Tính tổng các số nguyên tố từ 1 đến N")
    println("2. Tính số hạng thứ n thoe biểu thức X và Y")
    println("3. Nhập 2 ngày, cho biết ngày sớm nhất")
    println("4. Kiểm tra số đối xứng")
    println("5. Kiểm tra số tiến")
    println("6. Đếm số đối xứng chia hết cho 3")
    println("7. Đếm số tiến chia hết cho 5")
    println("0. Thoát")
    println("==================================")
}

// Menu chính
fun main() {
    while (true) {
        menu();
        print("Nhập lựa chọn của bạn: ")
        when (readLine()!!.toInt()) {
            1 -> tinhTongSoNguyenTo()
            2 -> tinhSoHang()
            3 -> soSanhNgay()
            4 -> kiemTraSoDoiXung()
            5 -> kiemTraSoTien()
            6 -> demSoDoiXungChiaHet3()
            7 -> demSoTienChiaHet5()
            0 -> {
                println("Thoát chương trình")
                return
            }
            else -> println("Lựa chọn không hợp lệ!")
        }
        println("=======================================");
    }
}
