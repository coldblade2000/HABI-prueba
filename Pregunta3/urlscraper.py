import re
def read_lines() -> list:
    N = int(input())
    lines = []
    for i in range(0, N):
        lines[i] = input()
    print(f"Se leyeron {N} lineas")
    return lines


def raw_urls_in_line(line: str) -> list:
    raw_list = re.findall(r'(http|https)\:\/\/(\w+\.)+\w+\/?', line)
    return raw_list

def process_raw_urls(url_list: list) -> list:
    final_list = set()
    for url in url_list:

        processed_url =