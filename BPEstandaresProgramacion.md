## <center> <span style="color:red">**Escuela**</span> <span style="color:white">**Politécnica**</span> <span style="color:blue">**Nacional**</span></center>
## <center>**Programación II - Examen Bimestral**</center>

### **Integrantes:** 

- Barahona Angel
- Parra Jhordy
------------
# <center>Estándares de programación</center>

El estándar de codificación para los scripts (Base de Datos) tendrá el siguiente formato:

Para nombrar tablas y campos, seguiremos la convención UpperCamelCase, donde cada nombre de tabla no incluirá abreviaturas.

Ejemplo:

***Tabla:***

- Sexo
- Persona

***Campos:***

- IdPersona
- Nombre
- Cédula
- Tipo

El estándar de codificación para la arquitectura N-TIER será el siguiente:

**Data Access:**

Las propiedades o atributos llevarán el mismo formato que los campos  de una tabla en Base de Datos; de igual manera las clases llevarán el nombre de las tablas, sin embargo utilizarán el sufijo DAO o DTO para distinguirlas.

Ejemplo: 

- PersonaDAO
- PersonaDTO

**Bussiness Logic:**

Para el nombramiento de las clases en esta sección, se empleará el sufijo BL.

Ejemplo:

- PersonaBL
- SexoBL

**Bussiness Entities**

El estándar para codificación de nuestra ampliación será **camelCase**. Utilizaremos como prefijo BP que son las iniciales de los integrantes del grupo del examen (BarahonaParra) para **clases** y el prefijo bp para variables **variables globales, variables locales, paquetes, atributos y métodos**

Por ejemplo:
***Clases:***
- public class BPHormiga{}

***Métodos:***

- void bpSetColor(){...}
- void bpGetNumber(){...}

***Variables:***

- int bpSuma;

***Atributos:*** 

- public int bpNombre;

**User Interface**

Los componentes de las interfaces gráficas harán uso de una abreviatura, la cual está dada por el tipo de componente.

Por ejemplo:

***Jpanel:***

- pnlAntBot

***JButton:***

- btnAntBot

***JLabel:***

- lblAntBot




