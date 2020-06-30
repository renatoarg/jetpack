package br.com.renatoarg.domain.exception

import java.lang.RuntimeException

class DomainException(e : Exception) : RuntimeException(e)