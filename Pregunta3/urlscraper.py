import re


# Se encarga de conseguir el input de la consola, y sacar el resultado de una busqueda preliminar de URLs del input
# Estas URLs todavia incluyen el slash al final y el protocol
def read_lines_for_urls() -> list:
    N = int(input("Por favor copiar y pegar el input entero de una: "))
    lines = ""
    for i in range(0, N):
        lines = lines + input()
    # Se usa un regex para buscar todas las urls tipo "https://www.google.com/" o similares,
    #   y las deja en una lista de matches
    raw_list = re.findall(r'((http|https)\:\/\/(\w+\.)+\w+\/?)', lines)
    return raw_list

# Toma urls sin procesar y le quita las partes innecesarias
def process_raw_urls(url_list: list) -> list[str]:
    # Se usa un set para no tener urls duplicadas
    final_set = set()
    for url_set in url_list:
        url = url_set[0]
        # Se busca eliminar el protocolo
        double_slash_end_idx = url.find("//") + 2
        no_protocol_url = url[double_slash_end_idx:]
        no_prefix_url = no_protocol_url
        # Se eliminan los prefijos tipoi www. o ww2. o ww.
        if re.match(r"((ww|ww\w)\.)", str(no_protocol_url[0:4])) is not None:
            no_prefix_url = no_prefix_url[no_protocol_url.find(".") + 1:]
        # Se quita el slash al final y cualquier otra cosa despues
        path_slash_idx = no_prefix_url.find("/")
        final_url = no_prefix_url[:path_slash_idx] if path_slash_idx != -1 else no_prefix_url
        final_set.add(final_url)
    final_list = list(final_set)
    # Se ordena la lista en orden lexigrafico
    final_list.sort()
    return final_list


raw_urls = read_lines_for_urls()
processed_urls = process_raw_urls(raw_urls)
print(";".join(processed_urls))
