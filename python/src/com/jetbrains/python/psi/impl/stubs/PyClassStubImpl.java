// Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.jetbrains.python.psi.impl.stubs;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.util.QualifiedName;
import com.intellij.util.ObjectUtils;
import com.jetbrains.python.psi.PyClass;
import com.jetbrains.python.psi.stubs.PyClassStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author max
 */
public class PyClassStubImpl extends StubBase<PyClass> implements PyClassStub {

  @Nullable
  private final String myName;

  @NotNull
  private final Map<QualifiedName, QualifiedName> mySuperClasses;
  private final List<String> mySubscriptedSuperClassesText;

  @Nullable
  private final QualifiedName myMetaClass;

  @Nullable
  private final List<String> mySlots;

  @Nullable
  private final String myDocString;

  @NotNull
  private final List<String> mySuperClassesText;

  @Nullable
  private final PyCustomClassStub myCustomStub;

  /**
   * @deprecated Use {@link PyClassStubImpl#PyClassStubImpl(String, StubElement, Map, List, QualifiedName, List, String, IStubElementType, PyCustomClassStub)} instead.
   * This constructor will be removed in 2019.2.
   */
  @Deprecated
  public PyClassStubImpl(@Nullable String name,
                         @Nullable StubElement parentStub,
                         @NotNull Map<QualifiedName, QualifiedName> superClasses,
                         @NotNull List<String> subscriptedSuperClassesText,
                         @Nullable QualifiedName metaClass,
                         @Nullable List<String> slots,
                         @Nullable String docString,
                         @NotNull IStubElementType stubElementType) {
    this(name, parentStub, superClasses, subscriptedSuperClassesText, Collections.emptyList(), metaClass, slots, docString, stubElementType, null);
  }

  /**
   * @deprecated Use {@link PyClassStubImpl#PyClassStubImpl(String, StubElement, Map, List, QualifiedName, List, String, IStubElementType, PyCustomClassStub)} instead.
   * This constructor will be removed in 2019.2.
   */
  @Deprecated
  public PyClassStubImpl(@Nullable String name,
                         @Nullable StubElement parentStub,
                         @NotNull Map<QualifiedName, QualifiedName> superClasses,
                         @NotNull List<String> subscriptedSuperClassesText,
                         @NotNull List<String> superClassesText,
                         @Nullable QualifiedName metaClass,
                         @Nullable List<String> slots,
                         @Nullable String docString,
                         @NotNull IStubElementType stubElementType,
                         @Nullable PyCustomClassStub customStub) {
    super(parentStub, stubElementType);
    myName = name;
    mySuperClasses = superClasses;
    mySubscriptedSuperClassesText = subscriptedSuperClassesText;
    mySuperClassesText = superClassesText;
    myMetaClass = metaClass;
    mySlots = slots;
    myDocString = docString;
    myCustomStub = customStub;
  }

  public PyClassStubImpl(@Nullable String name,
                         @Nullable StubElement parentStub,
                         @NotNull Map<QualifiedName, QualifiedName> superClasses,
                         @NotNull List<String> superClassesText,
                         @Nullable QualifiedName metaClass,
                         @Nullable List<String> slots,
                         @Nullable String docString,
                         @NotNull IStubElementType stubElementType,
                         @Nullable PyCustomClassStub customStub) {
    this(name, parentStub, superClasses, Collections.emptyList(), superClassesText, metaClass, slots, docString, stubElementType, customStub);
  }

  @Override
  @Nullable
  public String getName() {
    return myName;
  }

  @Override
  @NotNull
  public Map<QualifiedName, QualifiedName> getSuperClasses() {
    return mySuperClasses;
  }

  @NotNull
  @Override
  public List<String> getSubscriptedSuperClasses() {
    return mySubscriptedSuperClassesText;
  }

  @Nullable
  @Override
  public QualifiedName getMetaClass() {
    return myMetaClass;
  }

  @Nullable
  @Override
  public List<String> getSlots() {
    return mySlots;
  }

  @Nullable
  @Override
  public String getDocString() {
    return myDocString;
  }

  @NotNull
  @Override
  public List<String> getSuperClassesText() {
    return mySuperClassesText;
  }

  @Nullable
  @Override
  public <T> T getCustomStub(@NotNull Class<T> stubClass) {
    return ObjectUtils.tryCast(myCustomStub, stubClass);
  }

  @Override
  public String toString() {
    return "PyClassStub(" + myName + ")";
  }
}