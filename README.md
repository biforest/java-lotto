# ๐ ๋ก๋ 1๋จ๊ณ - ์๋

## ๊ธฐ๋ฅ ์๊ตฌ์ฌํญ
- ๋ก๋ ๊ตฌ์ ๊ธ์ก์ ์๋ ฅํ๋ฉด ๊ตฌ์ ๊ธ์ก์ ํด๋นํ๋ ๋ก๋๋ฅผ ๋ฐ๊ธํด์ผ ํ๋ค.
- ๋ก๋ 1์ฅ์ ๊ฐ๊ฒฉ์ 1000์์ด๋ค.

```
๊ตฌ์๊ธ์ก์ ์๋ ฅํด ์ฃผ์ธ์.
14000
14๊ฐ๋ฅผ ๊ตฌ๋งคํ์ต๋๋ค.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

์ง๋ ์ฃผ ๋น์ฒจ ๋ฒํธ๋ฅผ ์๋ ฅํด ์ฃผ์ธ์.
1, 2, 3, 4, 5, 6
๋ณด๋์ค ๋ณผ์ ์๋ ฅํด ์ฃผ์ธ์.
7

๋น์ฒจ ํต๊ณ
---------
3๊ฐ ์ผ์น (5000์)- 1๊ฐ
4๊ฐ ์ผ์น (50000์)- 0๊ฐ
5๊ฐ ์ผ์น (1500000์)- 0๊ฐ
5๊ฐ ์ผ์น, ๋ณด๋์ค ๋ณผ ์ผ์น(30000000์) - 0๊ฐ
6๊ฐ ์ผ์น (2000000000์)- 0๊ฐ
์ด ์์ต๋ฅ ์ 0.35์๋๋ค.(๊ธฐ์ค์ด 1์ด๊ธฐ ๋๋ฌธ์ ๊ฒฐ๊ณผ์ ์ผ๋ก ์ํด๋ผ๋ ์๋ฏธ์)
```

# ๐ ๋ก๋ 2๋จ๊ณ - ์๋ ๊ตฌ๋งค

## ๊ธฐ๋ฅ ์๊ตฌ์ฌํญ
- ํ์ฌ ๋ก๋ ์์ฑ๊ธฐ๋ ์๋ ์์ฑ ๊ธฐ๋ฅ๋ง ์ ๊ณตํ๋ค. ์ฌ์ฉ์๊ฐ ์๋์ผ๋ก ์ถ์ฒจ ๋ฒํธ๋ฅผ ์๋ ฅํ  ์ ์๋๋ก ํด์ผ ํ๋ค.
- ์๋ ฅํ ๊ธ์ก, ์๋ ์์ฑ ์ซ์, ์๋ ์์ฑ ๋ฒํธ๋ฅผ ์๋ ฅํ๋๋ก ํด์ผ ํ๋ค.

## ํ๋ก๊ทธ๋๋ฐ ์๊ตฌ์ฌํญ
- ์์ธ๊ฐ ๋ฐ์ํ๋ ๋ถ๋ถ์ ๋ํด ์๋ฐ Exception์ ์ ์ฉํด ์์ธ์ฒ๋ฆฌํ๋ค.
- ์ฌ์ฉ์๊ฐ ์๋ ฅํ ๊ฐ์ ๋ํ ์์ธ ์ฒ๋ฆฌ๋ฅผ ์ฒ ์ ํ ํ๋ค.

### ์คํ ๊ฒฐ๊ณผ
```
๊ตฌ์๊ธ์ก์ ์๋ ฅํด ์ฃผ์ธ์.
14000

์๋์ผ๋ก ๊ตฌ๋งคํ  ๋ก๋ ์๋ฅผ ์๋ ฅํด ์ฃผ์ธ์.
3

์๋์ผ๋ก ๊ตฌ๋งคํ  ๋ฒํธ๋ฅผ ์๋ ฅํด ์ฃผ์ธ์.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

์๋์ผ๋ก 3์ฅ, ์๋์ผ๋ก 11๊ฐ๋ฅผ ๊ตฌ๋งคํ์ต๋๋ค.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

์ง๋ ์ฃผ ๋น์ฒจ ๋ฒํธ๋ฅผ ์๋ ฅํด ์ฃผ์ธ์.
1, 2, 3, 4, 5, 6
๋ณด๋์ค ๋ณผ์ ์๋ ฅํด ์ฃผ์ธ์.
7

๋น์ฒจ ํต๊ณ
---------
3๊ฐ ์ผ์น (5000์)- 1๊ฐ
4๊ฐ ์ผ์น (50000์)- 0๊ฐ
5๊ฐ ์ผ์น (1500000์)- 0๊ฐ
5๊ฐ ์ผ์น, ๋ณด๋์ค ๋ณผ ์ผ์น(30000000์) - 0๊ฐ
6๊ฐ ์ผ์น (2000000000์)- 0๊ฐ
์ด ์์ต๋ฅ ์ 0.35์๋๋ค.(๊ธฐ์ค์ด 1์ด๊ธฐ ๋๋ฌธ์ ๊ฒฐ๊ณผ์ ์ผ๋ก ์ํด๋ผ๋ ์๋ฏธ์)
```

## ํ๋ก๊ทธ๋๋ฐ ์๊ตฌ์ฌํญ
- indent(์ธ๋ดํธ, ๋ค์ฌ์ฐ๊ธฐ) depth๋ฅผ 2๋จ๊ณ์์ 1๋จ๊ณ๋ก ์ค์ฌ๋ผ.
  - depth์ ๊ฒฝ์ฐ if๋ฌธ์ ์ฌ์ฉํ๋ ๊ฒฝ์ฐ 1๋จ๊ณ์ depth๊ฐ ์ฆ๊ฐํ๋ค. if๋ฌธ ์์ while๋ฌธ์ ์ฌ์ฉํ๋ค๋ฉด depth๊ฐ 2๋จ๊ณ๊ฐ ๋๋ค.
- else๋ฅผ ์ฌ์ฉํ์ง ๋ง๋ผ.
- ๋ฉ์๋์ ํฌ๊ธฐ๊ฐ ์ต๋ 10๋ผ์ธ์ ๋์ง ์๋๋ก ๊ตฌํํ๋ค.
  - method๊ฐ ํ ๊ฐ์ง ์ผ๋ง ํ๋๋ก ์ต๋ํ ์๊ฒ ๋ง๋ค์ด๋ผ.
- ๋ฐฐ์ด ๋์  ArrayList๋ฅผ ์ฌ์ฉํ๋ค.
- java enum์ ์ ์ฉํด ํ๋ก๊ทธ๋๋ฐ์ ๊ตฌํํ๋ค.
- ๊ท์น 3: ๋ชจ๋  ์์๊ฐ๊ณผ ๋ฌธ์์ด์ ํฌ์ฅํ๋ค.
- ๊ท์น 5: ์ค์ฌ์ฐ์ง ์๋๋ค(์ถ์ฝ ๊ธ์ง).
- ๊ท์น 8: ์ผ๊ธ ์ฝ๋ ์์ ์ด๋ค.

## ํํธ
- ๋ก๋ ์๋ ์์ฑ์ Collections.shuffle() ๋ฉ์๋ ํ์ฉํ๋ค.
- Collections.sort() ๋ฉ์๋๋ฅผ ํ์ฉํด ์ ๋ ฌ ๊ฐ๋ฅํ๋ค.
- ArrayList์ contains() ๋ฉ์๋๋ฅผ ํ์ฉํ๋ฉด ์ด๋ค ๊ฐ์ด ์กด์ฌํ๋์ง ์ ๋ฌด๋ฅผ ํ๋จํ  ์ ์๋ค.
