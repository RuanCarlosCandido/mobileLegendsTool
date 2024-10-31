import json
from collections import Counter

# Função para contar a frequência de cada nome nos counters e exibir em ordem decrescente
def contar_frequencia_counters(json_path):
    # Carregar o arquivo JSON
    with open(json_path, 'r') as file:
        data = json.load(file)

    # Extrair todos os nomes de counters e contar a frequência
    counter_list = [counter.lower() for item in data for counter in item.get("counters", [])]
    counter_frequency = Counter(counter_list)

    # Exibir o resultado em ordem decrescente de frequência
    for counter, freq in counter_frequency.most_common():
        print(f"{counter}: {freq}")

# Caminho do arquivo JSON
json_path = 'heroes_with_counters.json'
contar_frequencia_counters(json_path)
