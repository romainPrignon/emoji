FROM python:3.12

WORKDIR /opt

COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

COPY src/ src/
RUN coconut --strict src/ dist/
# RUN coconut --strict src/ dist/ --mypy

# ENTRYPOINT ["python", "/opt/dist/main.py"]