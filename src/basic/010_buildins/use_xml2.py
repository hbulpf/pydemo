#!/usr/bin/env python
# _*_coding:utf-8_*_

"""
@Time : 2022/1/6 15:09
@Author: RunAtWorld
@File: use_xml2.py.py
"""
import xml.etree.ElementTree as ET


def read_country():
    tree = ET.parse('country_data.xml')
    root = tree.getroot()
    # root = ET.fromstring(country_data_as_string)
    print(root.tag)
    print(root.attrib)

    # 查询
    for child in root:
        print(child.tag, child.attrib)
    print(root[0][1].text)

    for neighbor in root.iter('neighbor'):
        print(neighbor.attrib)

    for country in root.findall('country'):
        rank = country.find('rank').text
        name = country.get('name')
        print(name, rank)

    # 修改
    for rank in root.iter('rank'):
        new_rank = int(rank.text) + 1
        rank.text = str(new_rank)
        rank.set('updated', 'yes')
    tree.write('output.xml')

    # 删除
    for country in root.findall('country'):
        rank = int(country.find('rank').text)
        if rank > 50:
            root.remove(country)
    tree.write('remove_50.xml')


def build_country():
    a = ET.Element('data')
    b = ET.SubElement(a, 'country')
    c = ET.SubElement(b, 'year')
    d = ET.SubElement(a, 'country')
    ET.dump(a)


def use_namespace():
    """
    带命名空间的xml
    :return:
    """
    xml_text = r'''<?xml version="1.0"?>
    <actors xmlns:fictional="http://characters.example.com"
            xmlns="http://people.example.com">
        <actor>
            <name>John Cleese</name>
            <fictional:character>Lancelot</fictional:character>
            <fictional:character>Archie Leach</fictional:character>
        </actor>
        <actor>
            <name>Eric Idle</name>
            <fictional:character>Sir Robin</fictional:character>
            <fictional:character>Gunther</fictional:character>
            <fictional:character>Commander Clement</fictional:character>
        </actor>
    </actors>
    '''
    root = ET.fromstring(xml_text)
    # 遍历方式1
    for actor in root.findall('{http://people.example.com}actor'):
        name = actor.find('{http://people.example.com}name')
        print(name.text)
        for char in actor.findall('{http://characters.example.com}character'):
            print(' |-->', char.text)
    # 遍历方式2
    ns = {'real_person': 'http://people.example.com',
          'role': 'http://characters.example.com'}
    for actor in root.findall('real_person:actor', ns):
        name = actor.find('real_person:name', ns)
        print(name.text)
        for char in actor.findall('role:character', ns):
            print(' |-->', char.text)


def use_xpath():
    tree = ET.parse('country_data.xml')
    root = tree.getroot()

    # Top-level elements
    root.findall(".")

    # elements
    for node in root.findall("./country/neighbor"):
        print(node.tag, node.text, node.attrib)

    # Nodes with name='Singapore' that have a 'year' child
    for node in root.findall(".//year/..[@name='Singapore']"):
        print(node.tag, node.text, node.attrib)

    # 'year' nodes that are children of nodes with name='Singapore'
    for node in root.findall(".//*[@name='Singapore']/year"):
        print(node.tag, node.text, node.attrib)

    # All 'neighbor' nodes that are the second child of their parent
    for node in root.findall(".//neighbor[2]"):
        print(node.tag, node.text, node.attrib)

def operate_html():
    from xml.etree.ElementTree import ElementTree
    tree = ElementTree()
    tree.parse("demo.xhtml")
    p = tree.find("body/p")  # Finds first occurrence of tag p in body
    links = list(p.iter("a"))  # Returns list of all links
    for i in links:  # Iterates through all found links
        i.attrib["target"] = "blank"
    tree.write("html_output.xhtml")

if __name__ == '__main__':
    read_country()
    build_country()
    use_namespace()
    use_xpath()
    operate_html()
